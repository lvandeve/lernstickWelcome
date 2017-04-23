package ch.fhnw.lernstickwelcome.controller.binder;

import ch.fhnw.lernstickwelcome.controller.WelcomeController;
import ch.fhnw.lernstickwelcome.fxmlcontroller.WelcomeApplicationSystemController;
import javafx.stage.Stage;

/**
 *Binder class to init binings between view components and backend (model) properties
 * 
 * @author user
 */
public class ExamSystemBinder {

    private WelcomeController controller;
    private WelcomeApplicationSystemController system;
    
    /**
     * Constructor of ExamSystemBinder class
     * 
     * @param controller        is needed to provide access to the backend properties
     * @param system       FXML controller which prviedes the view properties
     */
    public ExamSystemBinder(WelcomeController controller, WelcomeApplicationSystemController system){
        this.controller = controller;
        this.system = system;
    }
    
    /**
     * Method to initialize the bidirectional bindings between the view and packend properties
     */
    public void initBindings(){
        system.getCb_sys_access_user().selectedProperty().bindBidirectional(controller.getPartition().accessExchangePartitionProperty());
        system.getCb_sys_allow_file_systems().selectedProperty().bindBidirectional(controller.getSysconf().allowAccessToOtherFilesystemsProperty());
        system.getCb_sys_block_kde().selectedProperty().bindBidirectional(controller.getSysconf().blockKdeDesktopAppletsProperty());
        system.getCb_sys_direct_sound().selectedProperty().bindBidirectional(controller.getSysconf().directSoundOutputProperty());
        system.getCb_sys_show_warning().selectedProperty().bindBidirectional(controller.getPartition().showReadWriteWelcomeProperty());
        system.getCb_sys_start_wa().selectedProperty().bindBidirectional(controller.getPartition().showReadOnlyInfoProperty());
        system.getChoice_sys_visible_for().valueProperty().bindBidirectional(controller.getSysconf().timeoutSecondsProperty());
        system.getTxt_sys_systemname().textProperty().bindBidirectional(controller.getSysconf().systemnameProperty());
        system.getTxt_sys_systemversion().textProperty().bindBidirectional(controller.getSysconf().systemversionProperty());
        system.getTxt_sys_exchange_partition().textProperty().bindBidirectional(controller.getPartition().exchangePartitionLabelProperty());
        system.getTxt_sys_password().textProperty().bindBidirectional(controller.getSysconf().passwordProperty());
        system.getTxt_sys_password_repeat().textProperty().bindBidirectional(controller.getSysconf().passwordRepeatProperty());
        system.getTxt_sys_username().textProperty().bindBidirectional(controller.getSysconf().usernameProperty());
        
        system.setHasExchangePartition(controller.getPartition().hasExchangePartition());
    }

    /**
     * Open other view by clicking on help button
     * @param helpStage     additional window showing help
     * @param help          links to online user guide
     */
    public void initHelp(Stage helpStage, HelpBinder help) {
        system.getBtnSysHelp().setOnAction(evt -> {
            help.setHelpEntry("System");
            helpStage.show();
        });
    }
    
}