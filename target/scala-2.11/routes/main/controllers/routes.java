
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/fschlesinger/Qsync/professional/workspace/netrunner/conf/routes
// @DATE:Mon Jun 26 11:07:56 CEST 2017

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseNetrunnerRestController NetrunnerRestController = new controllers.ReverseNetrunnerRestController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseImprintController ImprintController = new controllers.ReverseImprintController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseUserController UserController = new controllers.ReverseUserController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseNetrunnerController NetrunnerController = new controllers.ReverseNetrunnerController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseNetrunnerRestController NetrunnerRestController = new controllers.javascript.ReverseNetrunnerRestController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseImprintController ImprintController = new controllers.javascript.ReverseImprintController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseUserController UserController = new controllers.javascript.ReverseUserController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseNetrunnerController NetrunnerController = new controllers.javascript.ReverseNetrunnerController(RoutesPrefix.byNamePrefix());
  }

}
