package org.servicebroker.applifecycle.model;

import org.openpaas.servicebroker.model.*;
import org.servicebroker.applifecycle.service.TestConstants;

/**
 * The type Request fixture.
 */
public class RequestFixture {

    private static ServiceDefinition service = ServiceDefinitionFixture.getService();

    /**
     * Gets create service instance request.
     *
     * @return the create service instance request
     */
    public static CreateServiceInstanceRequest getCreateServiceInstanceRequest() {

        return new CreateServiceInstanceRequest(
                service.getId(),
                service.getPlans().get(0).getId(),
                TestConstants.ORG_GUID,
                TestConstants.SPACE_GUID,
                null
        ).withServiceInstanceId(TestConstants.SV_INSTANCE_ID);
    }

    /**
     * Gets create service instance binding request.
     *
     * @return the create service instance binding request
     */
    public static CreateServiceInstanceBindingRequest getCreateServiceInstanceBindingRequest() {

        return new CreateServiceInstanceBindingRequest(
                service.getId(),
                service.getPlans().get(0).getId(),
                TestConstants.APP_GUID);
    }

    /**
     * Gets delete service instance request.
     *
     * @return the delete service instance request
     */
    public static DeleteServiceInstanceRequest getDeleteServiceInstanceRequest() {

        ServiceInstance service = getServiceInstance();

        return new DeleteServiceInstanceRequest(
                service.getServiceInstanceId(),
                service.getServiceDefinitionId(),
                service.getPlanId());
    }

    /**
     * Gets update service instance request.
     *
     * @return the update service instance request
     */
    public static UpdateServiceInstanceRequest getUpdateServiceInstanceRequest() {

        ServiceDefinition service = ServiceDefinitionFixture.getService();

        return new UpdateServiceInstanceRequest(
                service.getPlans().get(0).getId(),
                service.getId());
    }

    /**
     * Gets delete service instance binding request.
     *
     * @return the delete service instance binding request
     */
    public static DeleteServiceInstanceBindingRequest getDeleteServiceInstanceBindingRequest() {

        ServiceInstance service = getServiceInstance();

        return new DeleteServiceInstanceBindingRequest(
                TestConstants.BIND_GUID,
                getServiceInstance(),
                service.getServiceDefinitionId(),
                service.getPlanId());
    }

    /**
     * Gets service instance.
     *
     * @return the service instance
     */
    public static ServiceInstance getServiceInstance() {
        ServiceInstance serviceInstance = new ServiceInstance(
                getCreateServiceInstanceRequest().withServiceInstanceId(TestConstants.SV_INSTANCE_ID))
                .withDashboardUrl(TestConstants.DASHBOARD_URL);

        return serviceInstance;

    }
}
