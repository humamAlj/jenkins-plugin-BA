package io.jenkins.plugins;

import hudson.model.AbstractItem;
import hudson.model.AbstractProject;
import java.io.File;

public class TestingResultProjectAction extends TestingBaseAction {
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

    @Override
    protected String getTitle() {
        return this.project.getDisplayName();
    }
}
