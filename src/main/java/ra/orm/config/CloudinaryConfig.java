package ra.orm.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary cloudinary(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name","dwqmfiprt",
                "api_key","547165255154353",
                "api_secret", "vzEY6Tk0t_mKQw3V5yfDB0F1LPI"));
    }
}
