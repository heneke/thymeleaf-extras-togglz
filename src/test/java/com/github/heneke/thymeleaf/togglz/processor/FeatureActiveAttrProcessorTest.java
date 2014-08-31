/*
 * =============================================================================
 *
 *   Copyright (c) 2014, Hendrik Heneke
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 * =============================================================================
 */
package com.github.heneke.thymeleaf.togglz.processor;

import org.junit.Test;
import org.thymeleaf.testing.templateengine.engine.TestExecutor;

import com.github.heneke.thymeleaf.togglz.AbstractTogglzTest;

import static com.github.heneke.thymeleaf.togglz.ThymeleafFeature.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class FeatureActiveAttrProcessorTest extends AbstractTogglzTest {

	@Test
	public void active() {
		assertThat(isFeatureActive(FEATURE_1), is(true));

		final TestExecutor executor = executor();
		executor.execute(getTestFile("active.thtest"));
		assertThat(executor.isAllOK(), is(true));
	}

	@Test
	public void inactive() {
		assertThat(isFeatureActive(FEATURE_2), is(false));

		final TestExecutor executor = executor();
		executor.execute(getTestFile("inactive.thtest"));
		assertThat(executor.isAllOK(), is(true));
	}

	@Test
	public void expr_active() {
		assertThat(isFeatureActive(FEATURE_1), is(true));

		final TestExecutor executor = executor();
		executor.execute(getTestFile("expr_active.thtest"));
		assertThat(executor.isAllOK(), is(true));
	}

	@Test
	public void expr_inactive() {
		assertThat(isFeatureActive(FEATURE_1), is(true));

		final TestExecutor executor = executor();
		executor.execute(getTestFile("expr_inactive.thtest"));
		assertThat(executor.isAllOK(), is(true));
	}
}
