import com.spring.pj1.hkh.controller.BoardController;
import com.spring.pj1.hkh.dto.HelloDto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BoardControllerTest {
    @Test
    public void 롬복_기능_테스트() throws Exception {
        String name = "test";
        int amt = 1000;

        HelloDto dto = new HelloDto(name, amt);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmt()).isEqualTo(amt);
    }
}
