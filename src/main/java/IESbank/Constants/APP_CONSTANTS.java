package IESbank.Constants;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix="admin")
@Data

public class APP_CONSTANTS {

    private Map<String,String> message = new HashMap<>();
}
