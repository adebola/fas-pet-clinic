package io.factorialsystems.faspetclinic.web.config;

import io.factorialsystems.faspetclinic.data.services.VetService;
import io.factorialsystems.faspetclinic.data.services.map.OwnerMapServiceImpl;
import io.factorialsystems.faspetclinic.data.services.map.VetMapServiceImpl;

//@Configuration
public class BeanConfig {

    //@Bean
    OwnerMapServiceImpl getOwnerService() {
        return null;
        //return new OwnerMapServiceImpl();
    }

    //@Bean
    VetService getVetService() {
        return null;
        // return new VetMapServiceImpl();
    }
}
