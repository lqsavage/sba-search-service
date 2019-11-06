package com.iihtibm.sba.proxy;

import com.iihtibm.sba.model.UserDtls;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author savagelee
 */
@FeignClient(value = "user-service", fallback = UserServiceFallback.class)
@RibbonClient(value = "user-service")
public interface UserServiceProxy {

	@GetMapping("/users/findById/{id}")
	public UserDtls findById(
			@PathVariable(value = "id", required = true) Long id);

}

@Component
class UserServiceFallback implements UserServiceProxy {

	@Override
	public UserDtls findById(Long id) {
		return new UserDtls();
	}
}