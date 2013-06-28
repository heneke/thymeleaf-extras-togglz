package org.thymeleaf.extras.togglz.dialect.processor;

import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.processor.attr.AbstractConditionalVisibilityAttrProcessor;
import org.thymeleaf.standard.processor.attr.StandardIfAttrProcessor;
import org.thymeleaf.util.StringUtils;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.manager.LazyResolvingFeatureManager;
import org.togglz.core.util.NamedFeature;

public class FeatureActiveAttrProcessor extends AbstractConditionalVisibilityAttrProcessor {

	public static final String ATTR_NAME = "active";
	public static final int ATTR_PRECEDENCE = StandardIfAttrProcessor.ATTR_PRECEDENCE;

	private final FeatureManager featureManager;

	public FeatureActiveAttrProcessor() {
		super(ATTR_NAME);
		this.featureManager = new LazyResolvingFeatureManager();
	}

	@Override
	protected boolean isVisible(Arguments arguments, Element element, String attributeName) {
		String attributeValue = element.getAttributeValue(attributeName);
		if (attributeValue == null || StringUtils.isEmpty(attributeValue).booleanValue()) {
			return false;
		}
		return isFeatureActive(attributeValue.trim());
	}

	@Override
	public int getPrecedence() {
		return ATTR_PRECEDENCE;
	}

	private boolean isFeatureActive(String name) {
		return featureManager.isActive(new NamedFeature(name));
	}

}
