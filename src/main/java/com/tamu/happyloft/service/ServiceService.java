package com.tamu.happyloft.service;

import com.tamu.happyloft.dto.ServiceDto;
import com.tamu.happyloft.dto.ServiceRequestDto;
import com.tamu.happyloft.model.ServiceCategory;
import com.tamu.happyloft.model.ServiceStatus;
import com.tamu.happyloft.model.User;
import com.tamu.happyloft.model.UserServices;
import com.tamu.happyloft.repository.ServiceCategoryRepository;
import com.tamu.happyloft.repository.ServiceRepository;
import com.tamu.happyloft.repository.ServiceStatusRepository;
import com.tamu.happyloft.repository.UserServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

/**
 * Created by arshi on 4/22/2020.
 */
@Service
public class ServiceService extends AbstractHelperService{

    @Autowired
    ServiceStatusRepository serviceStatusRepository;

    @Autowired
    ServiceCategoryRepository serviceCategoryRepository;

    @Autowired
    UserServiceRepository userServiceRepository;

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    EmailService emailService;

    public UserServices createService(ServiceDto serviceDto) {

        User existingUser = getUserByEmail(serviceDto.getUserEmail());
        if(null == existingUser) {
            throw new RuntimeException("User Record doesn't exist");
        }

        ServiceStatus serviceStatus = serviceStatusRepository.findByStatusName(serviceDto.getServiceStatus()).get(0);
        ServiceCategory serviceCategory = serviceCategoryRepository.findByServiceCategoryName(serviceDto.getServiceCategory()).get(0);

        com.tamu.happyloft.model.Service service = new com.tamu.happyloft.model.Service();

        service.setServiceCategoryID(serviceCategory);
        service.setServiceCategoryOther(serviceDto.getServiceCategoryOther());
        service.setServiceDate(serviceDto.getServiceDate());
        service.setServiceTime(serviceDto.getServiceTime());
        service.setServiceDescription(serviceDto.getServiceDescription());
        service.setServiceLocation(serviceDto.getServiceLocation());
        service.setServiceName(serviceDto.getServiceName());
        service.setServicePrice(serviceDto.getServicePrice());
        service.setServiceStatus(serviceStatus);

        com.tamu.happyloft.model.Service savedService = serviceRepository.save(service);

        UserServices userServices = new UserServices();

        userServices.setService(savedService);
        userServices.setUser(existingUser);
        userServices.setCreator(Boolean.TRUE);
        userServices.setInterested(Boolean.FALSE);
        userServices.setPerformer(Boolean.FALSE);

        return userServiceRepository.save(userServices);

    }

    public List<UserServices> fetchAllServices() {
        return userServiceRepository.findAll();
    }

    public void requestService(ServiceRequestDto serviceRequestDto) throws MessagingException {

        User existingRequester = getUserByEmail(serviceRequestDto.getRequesterEmail());
        if(null == existingRequester) {
            throw new RuntimeException("User Record for requester doesn't exist");
        }

        User existingServiceCreator = getUserByEmail(serviceRequestDto.getServiceCreatorEmail());
        if(null == existingServiceCreator) {
            throw new RuntimeException("User Record for service creator doesn't exist");
        }

        com.tamu.happyloft.model.Service service = serviceRepository.findById(Long.valueOf(serviceRequestDto.getServiceId())).get();

        service.setServiceStatus(serviceStatusRepository.findById(Long.valueOf(2)).get());

        UserServices userServices = new UserServices(existingRequester, service, false, true, false);

        userServiceRepository.save(userServices);

        emailService.exchangeRequestServiceInformation(existingRequester, existingServiceCreator, service);
    }

    public List<com.tamu.happyloft.model.Service> fetchFromServiceTable() {
        return serviceRepository.findAll();
    }
}
