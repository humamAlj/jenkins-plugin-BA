package io.jenkins.plugins;

import hudson.model.Action;
import hudson.tasks.Notifier;

public abstract class TestingBaseAction extends Notifier implements Action {
    private static final long serialVersionUID = 1L;

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
        return "notepad.png";
    }
    /*
       public String getJellyFile() {
           return "io/jenkins/plugins/TestingBaseAction/index.jelly"; // Pfad zur index.jelly-Datei
       }
    */
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
