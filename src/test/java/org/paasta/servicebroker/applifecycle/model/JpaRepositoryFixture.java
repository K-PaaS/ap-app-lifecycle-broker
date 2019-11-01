package org.paasta.servicebroker.applifecycle.model;

import org.openpaas.servicebroker.model.ServiceInstance;
import org.paasta.servicebroker.applifecycle.service.TestConstants;

import java.util.Date;

/**
 * The type Request fixture.
 */
public class JpaRepositoryFixture {

    /**
     * Gets jpa service instance.
     *
     * @return the jpa service instance
     */
    public static JpaServiceInstance getJpaServiceInstance() {

        ServiceInstance serviceInstance = RequestFixture.getServiceInstance();

        return new JpaServiceInstance(serviceInstance.getServiceInstanceId(),
                serviceInstance.getServiceDefinitionId(),
                serviceInstance.getPlanId(),
                serviceInstance.getOrganizationGuid(),
                serviceInstance.getSpaceGuid(),
                serviceInstance.getDashboardUrl(),
                new Date());
    }

    /**
     * Gets jpa dedicated vm.
     *
     * @return the jpa dedicated vm
     */
    public static JpaDedicatedVM getJpaDedicatedVM() {

        return JpaDedicatedVM.builder()
                .ip(TestConstants.DEDICATED_VM_IP)
                .vmName(TestConstants.DEDICATED_VM_NAME)
                .vmId(TestConstants.DEDICATED_VM_ID)
                .assignment(TestConstants.STATUS_WATING_FOR_ASSIGNMENT)
                .dashboardUrl(TestConstants.DASHBOARD_URL)
                .provisionedServiceInstanceId(TestConstants.SV_INSTANCE_ID)
                .provisionedTime(new Date())
                .createdTime(new Date())
                .build();
    }
}