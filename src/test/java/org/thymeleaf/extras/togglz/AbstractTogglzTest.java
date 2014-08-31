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
package org.thymeleaf.extras.togglz;

import java.util.Arrays;

import org.thymeleaf.extras.togglz.dialect.TogglzDialect;
import org.thymeleaf.standard.StandardDialect;
import org.thymeleaf.testing.templateengine.engine.TestExecutor;
import org.thymeleaf.testing.templateengine.report.ConsoleTestReporter;
import org.togglz.core.Feature;
import org.togglz.core.context.FeatureContext;
import org.togglz.testing.TestFeatureManager;
import org.togglz.testing.TestFeatureManagerProvider;

import static org.thymeleaf.extras.togglz.ThymeleafFeature.*;

public class AbstractTogglzTest {

	private final TestFeatureManager featureManager = new TestFeatureManager(ThymeleafFeature.class);
	private final TestExecutor executor = new TestExecutor();

	public AbstractTogglzTest() {
		featureManager.enable(FEATURE_1);
		TestFeatureManagerProvider.setFeatureManager(featureManager);
		executor.setDialects(Arrays.asList(new StandardDialect(), new TogglzDialect()));
		executor.setReporter(new ConsoleTestReporter());
	}

	protected boolean isFeatureActive(Feature feature) {
		return FeatureContext.getFeatureManager().isActive(feature);
	}

	protected TestExecutor executor() {
		executor.reset();
		return executor;
	}

}
