// import HellOnWorld;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
// import org.junit.Test;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HellOnWorld_FunTest {

    private HellOnWorld app = new HellOnWorld();

    @Test
    public void GET_hell_on_world_as_200() {
        //app.start(7000);
        HttpResponse response = Unirest.get("http://localhost:7000/").asString();
        assertThat(response.getStatus()).isEqualTo(200);
	assertThat(response.getBody()).isEqualTo("Hell-On-World");
        //app.stop();
    }

}
