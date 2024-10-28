package io.jenkins.plugins;

import hudson.model.Action;
import hudson.tasks.Notifier;

public abstract class TestingBaseAction extends Notifier implements Action {

    @Override
    public String getDisplayName() {
        return "Build Ergebnisse anzeigen";
    }

    @Override
    public String getUrlName() {
        return "buildErgebnisse";
    }

    @Override
    public String getIconFileName() {
        return null;
    }
    /*
       public void doDynamic(StaplerRequest req, StaplerResponse rsp) throws IOException, ServletException {
           DirectoryBrowserSupport dbs =
                   new DirectoryBrowserSupport(this, new FilePath(this.dir()), this.getTitle(), null, false);
           dbs.generateResponse(req, rsp, this);
       }
    */
    protected abstract String getTitle();

    // protected abstract File dir();
}
