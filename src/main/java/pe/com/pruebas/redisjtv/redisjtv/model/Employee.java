package pe.com.pruebas.redisjtv.redisjtv.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@RedisHash("Employee")
public class Employee {
	@Id
	private @NonNull String id;
	private @NonNull String firstName;
	private @NonNull String lastName;
	private @NonNull String email;
	private @NonNull Boolean active;

	public Employee() {

	}
}
