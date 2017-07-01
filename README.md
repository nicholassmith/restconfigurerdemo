# restconfigurerdemo
Demo project to show how to configure Spring MVC Rest Repository fully.

Spring's documentation is reasonably vague about how to programatically extend the `RepositoryRestMvcConfiguration` to replace, for example, the `URIToEntityConverter`. This project shows one way to extend this whilst also preserving various other components that are automatically configured by Spring such as the `Jackson` JSON message converters. 
