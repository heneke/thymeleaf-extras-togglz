Thymeleaf Togglz dialect
========================

Thymeleaf dialect that integrates Togglz feature toggles (www.togglz.org) and the Thymeleaf template engine (www.thymeleaf.org).

Requirements
------------

 *  Thymeleaf
    * 2.1.x (works with older 2.0.x versions - see remark regarding expression evaulation) - using thymeleaf-extras-togglz **version 1.x**
    * 3.x - using thymeleaf-extras-togglz **version 2.x**
 *  Togglz 2.3.x (works with older 2.x versions)
 
Usage
-----

Add an instance of com.github.heneke.thymeleaf.togglz.TogglzDialect to your Thymeleaf template engine. In your templates, you may now use

```html
<div togglz:active="YOUR_FEATURE_NAME">
    content only visible if feature is active
</div>
<div togglz:inactive="YOUR_FEATURE_NAME">
    content only visible if feature is <b>inactive</b>
</div>
```

to show/hide the markup container based on feature state.

Optionally, you may add an XML namespace to your `<html>` tag, to suppress warnings in your IDE:

```html
<html lang="en"
	xmlns:th="http://www.thymeleaf.org"
	xmlns:togglz="https://github.com/heneke/thymeleaf-extras-togglz">
```

Until recently, the expression processor for togglz:active did not support expressions. Since it does so now, you have to use 

````html
<div togglz:active="'YOUR_FEATURE_NAME'">
    content only visible if feature is active
</div>
<div togglz:inactive="'YOUR_FEATURE_NAME'">
    content only visible if feature is <b>inactive</b>
</div>
```

when using Thymeleaf 2.0.x. Thymeleaf 2.1 does support string literals without single quotes as explained in the usage section (see http://www.thymeleaf.org/whatsnew21.html#littok).
