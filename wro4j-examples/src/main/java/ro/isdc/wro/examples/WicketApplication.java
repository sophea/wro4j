package ro.isdc.wro.examples;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.HttpSessionStore;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.session.ISessionStore;


/**
 * Application object for your web application. If you want to run this application without deploying, run the Start
 * class.
 *
 * @see wicket.myproject.Start#main(String[])
 */
public class WicketApplication
    extends WebApplication {
  /**
   * Constructor
   */
  public WicketApplication() {
  }

  /**
   * @see wicket.Application#getHomePage()
   */
  @Override
  public Class<? extends WebPage> getHomePage() {
    return HomePage.class;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void init() {
    // for Google App Engine
    getResourceSettings().setResourcePollFrequency(null);
    mountBookmarkablePage("/home", HomePage.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getConfigurationType() {
    return DEPLOYMENT;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected ISessionStore newSessionStore() {
    return new HttpSessionStore(this);
  }

}