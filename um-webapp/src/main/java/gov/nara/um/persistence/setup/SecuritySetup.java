package gov.nara.um.persistence.setup;

import java.util.Set;

import gov.nara.um.util.Um;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import gov.nara.common.spring.util.Profiles;
import gov.nara.um.persistence.model.Role;
import gov.nara.um.persistence.model.User;
import com.google.common.collect.Sets;

/**
 * This simple setup class will run during the bootstrap process of Spring and will create some setup data <br>
 * The main focus here is creating some standard privileges, then roles and finally some default principals/users
 */
@Component
@Profile(Profiles.DEPLOYED)
public class SecuritySetup implements ApplicationListener<ContextRefreshedEvent> {
    private final Logger logger = LoggerFactory.getLogger(SecuritySetup.class);

    private boolean setupDone;


    public SecuritySetup() {
        super();
    }

    //

    /**
     * - note that this is a compromise - the flag makes this bean statefull which can (and will) be avoided in the future by a more advanced mechanism <br>
     * - the reason for this is that the context is refreshed more than once throughout the lifecycle of the deployable <br>
     * - alternatives: proper persisted versioning
     */
    @Override
    public final void onApplicationEvent(final ContextRefreshedEvent event) {
        if (!setupDone) {
            logger.info("Executing Setup");

            //createPrivileges();
            //createRoles();
            //createUsers();

            setupDone = true;
            logger.info("Setup Done");
        }
    }



    // Role

    private void createRoles() {
        //final Privilege canPrivilegeRead = privilegeService.findByName(Um.Privileges.CAN_PRIVILEGE_READ);
       // final Privilege canPrivilegeWrite = privilegeService.findByName(Um.Privileges.CAN_PRIVILEGE_WRITE);
       // final Privilege canRoleRead = privilegeService.findByName(Um.Privileges.CAN_ROLE_READ);
       // final Privilege canRoleWrite = privilegeService.findByName(Um.Privileges.CAN_ROLE_WRITE);
       // final Privilege canUserRead = privilegeService.findByName(Um.Privileges.CAN_USER_READ);
       // final Privilege canUserWrite = privilegeService.findByName(Um.Privileges.CAN_USER_WRITE);

       // Preconditions.checkNotNull(canPrivilegeRead);
       // Preconditions.checkNotNull(canPrivilegeWrite);
       // Preconditions.checkNotNull(canRoleRead);
       // Preconditions.checkNotNull(canRoleWrite);
       // Preconditions.checkNotNull(canUserRead);
       // Preconditions.checkNotNull(canUserWrite);

       // createRoleIfNotExisting(Um.Roles.ROLE_ADMIN, Sets.<Privilege> newHashSet());
    }


    // User/User

    final void createUsers() {
        final Role roleAdmin = new Role("admin");
        roleAdmin.setDescription("test admin role");
        roleAdmin.setName("admin role");

        // createUserIfNotExisting(SecurityConstants.ADMIN_USERNAME, SecurityConstants.ADMIN_PASS, Sets.<Role> newHashSet(roleAdmin));
        createUserIfNotExisting(Um.ADMIN_EMAIL, Um.ADMIN_PASS, Sets.<Role> newHashSet(roleAdmin));
    }

    final void createUserIfNotExisting(final String loginName, final String pass, final Set<Role> roles) {

    }

}