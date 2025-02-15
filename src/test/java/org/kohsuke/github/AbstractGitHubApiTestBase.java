package org.kohsuke.github;

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.kohsuke.randname.RandomNameGenerator;

import java.io.File;
import java.io.IOException;

import static org.junit.Assume.assumeTrue;

/**
 * @author Kohsuke Kawaguchi
 */
public abstract class AbstractGitHubApiTestBase extends AbstractGitHubApiWireMockTest {

    @Before
    public void setUp() throws Exception {
        assumeTrue( "All tests inheriting from this class are not guaranteed to work without proxy", githubApi.isUseProxy());
    }

    protected GHUser getUser() {
        try {
            return gitHub.getMyself();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    protected void kohsuke() {
        String login = getUser().getLogin();
        assumeTrue(login.equals("kohsuke") || login.equals("kohsuke2"));
    }

    protected static final RandomNameGenerator rnd = new RandomNameGenerator();
}
