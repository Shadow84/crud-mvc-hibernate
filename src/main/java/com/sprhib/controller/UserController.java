package com.sprhib.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.sprhib.model.FindObj;
import com.sprhib.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addUserPage() {
		ModelAndView modelAndView = new ModelAndView("add-user-form");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingUser(@ModelAttribute User user) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		userService.addUser(user);
		
		String message = "User was successfully added.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}

	@RequestMapping(value="/list")
	 public ModelAndView listOfUsers(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("list-of-users");
		List<User> users = userService.getUsers();

		PagedListHolder<User>  pagedListHolder = new PagedListHolder<User>(users);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPageSize(10);
		pagedListHolder.setPage(page);
		modelAndView.addObject("pagedListHolder", pagedListHolder);

		return modelAndView;
	}

	@RequestMapping(value="/find", method=RequestMethod.GET)
	 public ModelAndView findUser() {
		ModelAndView modelAndView = new ModelAndView("find-user-form");
		List<User> users = userService.getUsers();
		modelAndView.addObject("findObj", new FindObj());
		modelAndView.addObject("users", users);
		return modelAndView;
	}

	@RequestMapping(value="/find", method=RequestMethod.POST)
	public ModelAndView findUser(@ModelAttribute  FindObj findObj) {
		ModelAndView modelAndView = new ModelAndView("find-user-form");
		List<User> users = new ArrayList<User>();

		switch (findObj.getField()) {
			case "id" :
				Integer from = Integer.parseInt(findObj.getFrom());
				Integer to = Integer.parseInt(findObj.getTo());
				users = userService.getUsersByIdBetwen(from,to,findObj.getSort() );
				break;
			case "name":
				users = userService.getUsersByNameBetwen(findObj.getFrom(), findObj.getTo(),findObj.getSort());
				break;
			case "age":
				Integer fromInt = Integer.parseInt(findObj.getFrom());
				Integer toInt = Integer.parseInt(findObj.getTo());
				users = userService.getUsersByAgeBetwen(fromInt, toInt, findObj.getSort());
				break;
			case "createdDate":
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date fromDate = new Date();
				Date toDate = new Date();
				try {
					fromDate = df.parse(findObj.getFrom());
					toDate = df.parse(findObj.getTo());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				users = userService.getUsersByCreatedDateBetwen(fromDate, toDate,findObj.getSort());
				break;
		}

		switch (findObj.getSort()) {
			case "id" :
				Collections.sort(users, new Comparator<User>() {
					@Override
					public int compare(User o1, User o2) {
						return o1.getId().compareTo(o2.getId());
					}
				});
				break;
			case "name":
				Collections.sort(users, new Comparator<User>() {
					@Override
					public int compare(User o1, User o2) {
						return o1.getName().compareTo(o2.getName());
					}
				});
				break;
			case "age":
				Collections.sort(users, new Comparator<User>() {
					@Override
					public int compare(User o1, User o2) {
						return o1.getAge().compareTo(o2.getAge());
					}
				});
				break;
			case "isAdmin":
				Collections.sort(users, new Comparator<User>() {
					@Override
					public int compare(User o1, User o2) {
						return o2.getIsAdmin().compareTo(o1.getIsAdmin());
					}
				});
				break;
			case "createdDate":
				Collections.sort(users, new Comparator<User>() {
					@Override
					public int compare(User o1, User o2) {
						return o1.getCreatedDate().compareTo(o2.getCreatedDate());
					}
				});
				break;
		}

		modelAndView.addObject("findObj", new FindObj());
		modelAndView.addObject("users", users);
		return modelAndView;
	}

	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	 public ModelAndView editUserPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("edit-user-form");
		User user = userService.getUser(id);
		modelAndView.addObject("user", user);
		return modelAndView;
	}

	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingUser(@ModelAttribute User user, @PathVariable Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		
		userService.updateUser(user);
		
		String message = "User was successfully edited.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}



	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		userService.deleteUser(id);
		String message = "User was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}

}
