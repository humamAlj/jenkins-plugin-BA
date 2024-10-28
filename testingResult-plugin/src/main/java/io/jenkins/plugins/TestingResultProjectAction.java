package io.jenkins.plugins;

import hudson.model.AbstractItem;
import hudson.model.AbstractProject;
import hudson.model.Action;
import hudson.model.Run;
import java.io.File;

public class TestingResultProjectAction extends TestingBaseAction implements Action {
    private final AbstractProject<?, ?> project;

    public TestingResultProjectAction(AbstractProject<?, ?> project) {
        super();
        this.project = project;
    }
    /*
       protected File dir() {
           if (this.project instanceof AbstractProject) {
               Run run = project.getLastCompletedBuild();
               if (run != null) {
                   File javadocDir = getBuildArchiveDir(run);

                   if (javadocDir.exists()) {
                       return javadocDir;
                   }
               }
           }
           return getProjectArchiveDir(this.project);
       }
    */
    private File getProjectArchiveDir(AbstractItem project) {
        return new File(project.getRootDir(), "testing-reports");
    }

    /**
     * Gets the directory where the HTML report is stored for the given build.
     */
    private File getBuildArchiveDir(Run run) {
        return new File(run.getRootDir(), "testing-reports");
    }

    protected String getTitle() {
        return this.project.getDisplayName();
    }
}
