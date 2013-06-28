Thymeleaf Togglz dialect
========================

Thymeleaf dialect that integrates Togglz feature toggles (www.togglz.org) and the Thymeleaf template engine (www.thymeleaf.org).

Requirements
------------

 *  Thymeleaf 2.0.17 (should work with older 2.x versions, too)
 *  Togglz 2.0.0
 
Usage
-----

Add an instance of org.thymeleaf.extras.togglz.dialect.TogglzDialect to your Thymeleaf template engine. In your templates, you may not use

```html
<div togglz:active="YOUR_FEATURE_NAME">
    content only visible if feature is active
</div>
```

to show/hide the markup container based on feature state.
