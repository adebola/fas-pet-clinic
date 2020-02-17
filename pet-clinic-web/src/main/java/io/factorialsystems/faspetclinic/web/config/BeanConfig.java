package io.factorialsystems.faspetclinic.web.config;

import io.factorialsystems.faspetclinic.data.services.OwnerService;
import io.factorialsystems.faspetclinic.data.services.VetService;
import io.factorialsystems.faspetclinic.data.services.map.OwnerMapServiceImpl;
import io.factorialsystems.faspetclinic.data.services.map.VetMapServiceImpl;

//@Configuration
public class BeanConfig {

    //@Bean
    OwnerService getOwnerService() {
        return new OwnerMapServiceImpl();
    }

    //@Bean
    VetService getVetService() {
        return new VetMapServiceImpl();
    }
}
