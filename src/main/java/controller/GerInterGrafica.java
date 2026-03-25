package controller;

import viewer.FrmPrincipal;
import viewer.DlgCadCliente;



public class GerInterGrafica {

    private static GerInterGrafica instancia;
    private FrmPrincipal frmPrincipal;

    private GerInterGrafica() {}

    public static GerInterGrafica getInstancia() {
        if (instancia == null)
            instancia = new GerInterGrafica();
        return instancia;
    }

    public void iniciar() {
        frmPrincipal = new FrmPrincipal();
        frmPrincipal.setVisible(true);
    }

    public void abrirCadCliente() {
        DlgCadCliente dlg = new DlgCadCliente(frmPrincipal, true);
        dlg.setVisible(true);
    }

    public void abrirEditarPaciente() {
        // DlgEditarPaciente dlg = new DlgEditarPaciente(frmPrincipal, true);
        // dlg.setVisible(true);
    }

    public void abrirListarPaciente() {
        // DlgListarPaciente dlg = new DlgListarPaciente(frmPrincipal, true);
        // dlg.setVisible(true);
    }

    public void abrirAgenda() {
        // DlgAgenda dlg = new DlgAgenda(frmPrincipal, true);
        // dlg.setVisible(true);
    }

    public void abrirProntuario() {
        // DlgProntuario dlg = new DlgProntuario(frmPrincipal, true);
        // dlg.setVisible(true);
    }

    public static void main(String[] args) {
        /* Look and feel Nimbus */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerInterGrafica.class.getName())
                .log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> GerInterGrafica.getInstancia().iniciar());
    }
}