package org.openstack.api.compute.ext;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.NovaSecurityGroup;
import org.openstack.model.compute.NovaSecurityGroupList;

public class SecurityGroupsResource extends Resource {
	
	public SecurityGroupsResource(Target target) {
		super(target);
	}

	public NovaSecurityGroupList get() {
		return target.request(MediaType.APPLICATION_JSON).get(NovaSecurityGroupList.class);
	}
	
	public NovaSecurityGroup post(Entity<NovaSecurityGroup> securityGroup) {
		return target.request(MediaType.APPLICATION_JSON).post(securityGroup, NovaSecurityGroup.class);
		
	}
	
	public SecurityGroupResource securityGroup(int id) {
		return new SecurityGroupResource(target.path("/{id}").pathParam("id", id));
	}

	
}
