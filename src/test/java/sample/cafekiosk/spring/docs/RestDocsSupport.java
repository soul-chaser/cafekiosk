package sample.cafekiosk.spring.docs;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;

@ExtendWith(RestDocumentationExtension.class)
//@SpringBootTest
public abstract class RestDocsSupport {

    protected MockMvc mockMvc;
    protected ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp(
//            WebApplicationContext webApplicationContext,
            RestDocumentationContextProvider provider) {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(initController())
//                .webAppContextSetup(webApplicationContext)
                .apply(documentationConfiguration(provider))
                .build();
    }

    protected abstract Object initController();

}
