package org.stepio.strings.rest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.stepio.strings.spring.ApplicationTests;
import springfox.documentation.spring.web.plugins.Docket;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link Swagger2Config}.
 *
 * @author stepio
 */
public class Swagger2ConfigTest extends ApplicationTests {

    @Autowired
    private Swagger2Config swagger2Config;
    @Autowired
    private Docket docket;

    @Test
    public void swagger2Enabled_isTrue() {
        assertThat(this.swagger2Config.swagger2Enabled).isTrue();
    }

    @Test
    public void docket_isNotNull() {
        assertThat(this.docket).isNotNull();
    }
}
