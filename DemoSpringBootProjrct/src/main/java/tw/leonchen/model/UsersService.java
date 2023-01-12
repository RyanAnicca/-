package tw.leonchen.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsersService {

	@Autowired
	private UsersRepository uRepo;

	public List<Users> findAllUsers(String name) {
		return uRepo.findAllUsers(name);
	}

	public List<Users> findByUsernameLike(String name) {
		return uRepo.findByUsernameLike(name);
	}

	public List<Users> findAll() {
		return uRepo.findAll();
	}
	
	public List<Users> findAll2() {
		return uRepo.findAll();
	}
}
