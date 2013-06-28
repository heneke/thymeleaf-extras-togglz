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
