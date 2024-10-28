package io.jenkins.plugins;

import hudson.Extension;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.Action;
import hudson.model.BuildListener;
import hudson.model.Computer;
import hudson.slaves.SlaveComputer;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Publisher;
import hudson.tasks.Recorder;
import java.io.IOException;
import org.kohsuke.stapler.DataBoundConstructor;

public class TestingResultPublisher extends Recorder {
    /*  String pcError = "PC nicht gestartet";
    String buildError = "Code könnte nicht gebildet werden";
    String testsoftwareError = "testSoftware könnte nicht ausgeführt werden";
    String testError = "test fehlgeschlagen";
    String skriptError = "testskript error";
    String connectionError = "fehler bei verbindung";
     */
    public final String errorString;
    public final String customMessage;

    @DataBoundConstructor
    public TestingResultPublisher(String errorString, String customMessage) {
        this.errorString = errorString;
        this.customMessage = customMessage;
    }
    /*
       public TestingResultPublisher add(BuildStepDescriptor<Publisher> d) {
           this.add(d);
           return this;
       }
    */
    @Override
    public boolean perform(AbstractBuild<?, ?> build, Launcher launcher, BuildListener listener)
            throws IOException, InterruptedException {
        // DescriptorImpl descriptor = new DescriptorImpl();

        build.addAction(new TestingResultBuildAction((AbstractBuild<?, ?>) build));

        listener.getLogger().println("Build Number: " + build.getNumber());
        listener.getLogger().println("Project Name: " + build.getDisplayName());

        if (Computer.currentComputer() instanceof SlaveComputer) {
            listener.getLogger().println("current Computer used");

        } else {
            listener.getLogger().println("another Computer used");
        }

        listener.getLogger().println("Error String: " + errorString);
        listener.getLogger().println("Custom String: " + customMessage);
        listener.getLogger().println("TestingResultPublisher completed");

        return true;
    }

    @Override
    public Action getProjectAction(AbstractProject<?, ?> project) {
        return new TestingResultProjectAction(project);
    }

    @Override
    public DescriptorImpl getDescriptor() {
        return (DescriptorImpl) super.getDescriptor();
    }

    @Extension
    public static class DescriptorImpl extends BuildStepDescriptor<Publisher> {

        public DescriptorImpl() {
            super(TestingResultPublisher.class);
            load();
        }

        @Override
        public String getDisplayName() {
            return "publish test result";
        }

        @Override
        public boolean isApplicable(Class<? extends AbstractProject> jobType) {
            return true;
        }
        /*
             public String getConfigPage() {
                 return "io/jenkins/plugins/TestingResultPublisher/config.jelly"; // Gibt den Pfad zur config.jelly-Datei an
             }

             public String getJellyFile() {
                 return "io/jenkins/plugins/TestingResultPublisher/index.jelly"; // Pfad zur index.jelly-Datei
             }
        */
    }

    @Override
    public BuildStepMonitor getRequiredMonitorService() {
        return BuildStepMonitor.NONE;
    }

    public String getCustomMessage() {
        return customMessage;
    }

    public String getErrorString() {
        return errorString;
    }
}
