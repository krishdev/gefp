/*
 * This file is part of the CSNetwork Services (CSNS) project.
 * 
 * Copyright 2012, Chengyu Sun (csun@calstatela.edu).
 * 
 * CSNS is free software: you can redistribute it and/or modify it under the
 * terms of the GNU Affero General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option)
 * any later version.
 * 
 * CSNS is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for
 * more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with CSNS. If not, see http://www.gnu.org/licenses/agpl.html.
 */
package gefp.web.service;

import gefp.model.User;
import gefp.model.dao.StuDdao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("userServ")
public class UserService {

    @Autowired
    private StuDdao userDao;

    @RequestMapping("/service/user/login")
    public String login( @RequestParam String username,
        @RequestParam String password, ModelMap models )
    {
    	System.out.println("userservice");
        User user = userDao.getUserByUsername( username );
       
        models.put( "user", user );
        return "jsonView";
    }

}
