package org.thymeleaf.extras.togglz.dialect.processor;

import org.junit.Test;
import org.thymeleaf.extras.togglz.AbstractTogglzTest;
import org.thymeleaf.testing.templateengine.engine.TestExecutor;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import static org.thymeleaf.extras.togglz.ThymeleafFeature.*;

public class FeatureActiveAttrProcessorTest extends AbstractTogglzTest {

	@Test
	public void active() {
		assertThat(isFeatureActive(FEATURE_1), is(true));

		final TestExecutor executor = executor();
		executor.execute("classpath:org/thymeleaf/extras/togglz/dialect/processor/active.thtest");
		assertThat(executor.isAllOK(), is(true));
	}

	@Test
	public void inactive() {
		assertThat(isFeatureActive(FEATURE_2), is(false));

		final TestExecutor executor = executor();
		executor.execute("classpath:org/thymeleaf/extras/togglz/dialect/processor/inactive.thtest");
		assertThat(executor.isAllOK(), is(true));
	}

}
