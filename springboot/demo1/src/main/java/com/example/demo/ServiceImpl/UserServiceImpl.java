package com.example.demo.ServiceImpl;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
    UserRepository userrepository;
	@Override
	public boolean savOrUpdate(UserDto userdto) {
	    User us=new User();
	    us.setId(userdto.getId());
	    us.setname(userdto.getName());
	    us.setprice(userdto.getPrice());
	    userrepository.save(us);
		return true;
	}
	@Override
	public boolean deleteById(int id) {
		userrepository.deleteById(id);
		return true;
	}
	@Override
	public List<User> getAllUser() {
		List<User> use = userrepository.findAll();
		return use;
	}
	@Override
	public Optional<User> getById(int id) {
		Optional<User> use = userrepository.findById(id);
		return use;
	}
//	@Override
//	public int softDeleteById(int id) {
//		softDeleteById(id);
//		return 0;
//	}
	@Override
	public String signUp(UserDto userdto) {
			List<User> usname = userrepository.findByName(userdto.getName());
			if (usname != null) {
				List<User> usmail = userrepository.findByMail(userdto.getMail());
				if (usmail != null) {
					List<User> usphone = userrepository.findByPhone(userdto.getPhone());
					if (usphone != null) {
						List<User> uspassword = userrepository.findByPassword(userdto.getPassword());
						if (uspassword != null) {
							User user = new User();
							BeanUtils.copyProperties(userdto, user);
							user.setPassword(this.encode(user.getPassword()));
							userrepository.save(user);
							return "success";
						}
						return "check password";

					}
					return "check phone num ";
				}
				return "check mail";

			}
			return "check name";
			// return null;
		}

		public String encode(String encodedpassword) {
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());
			return bCryptPasswordEncoder.encode(encodedpassword);

		}

		public boolean decode(String text, String text2) {
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
			return bCryptPasswordEncoder.matches(text, text2);

	}
	@Override
	public String signIn(String name, String Password) {
			List<User> users = userrepository.findByNameOrPhoneOrMail(name, name, name);
			String status = "";
			if (users.size()>0) {
				for(User userss:users) {
				//User user = users.get();
				if (this.decode(Password,userss.getPassword())) {
					status = "Successfully Login";
				} else {
					status = "Check Password";
				}
				}
			} 
			
			else {
				status = "No Data Found";
			}
			return status;
		

	}

	
}

		


