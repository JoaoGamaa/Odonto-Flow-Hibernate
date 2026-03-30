package controller;

import viewer.FrmPrincipal;
import viewer.DlgCadCliente;
import viewer.DlgAgenda;
import viewer.DlgEscolherPaciente;
import viewer.DlgProntuario;
import javax.swing.JOptionPane;
import model.Paciente;



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
        if (!CtrlPacientes.getInstancia().possuiPacientes()) {
            JOptionPane.showMessageDialog(frmPrincipal, "Nenhum paciente cadastrado.",
                    "Pacientes", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder lista = new StringBuilder("Pacientes cadastrados:\n\n");
        for (Paciente paciente : CtrlPacientes.getInstancia().getPacientes()) {
            lista.append("- ").append(paciente.getNome())
                .append(" | CPF: ").append(paciente.getCpf())
                .append('\n');
        }

        JOptionPane.showMessageDialog(frmPrincipal, lista.toString(),
                "Pacientes", JOptionPane.INFORMATION_MESSAGE);
    }

    public void abrirAgenda() {
        DlgAgenda dlg = new DlgAgenda(frmPrincipal, true);
        dlg.setLocationRelativeTo(frmPrincipal);
        dlg.setVisible(true);
    }

    public void abrirProntuario() {
        if (!CtrlPacientes.getInstancia().possuiPacientes()) {
            JOptionPane.showMessageDialog(frmPrincipal, "Cadastre um paciente primeiro.",
                    "Prontuario", JOptionPane.WARNING_MESSAGE);
            return;
        }

        DlgEscolherPaciente dlgEscolher = new DlgEscolherPaciente(frmPrincipal, true);
        dlgEscolher.setLocationRelativeTo(frmPrincipal);
        dlgEscolher.setVisible(true);

        Paciente paciente = CtrlPacientes.getInstancia().getPacienteSelecionado();
        if (paciente == null) {
            return;
        }

        DlgProntuario dlg = new DlgProntuario(frmPrincipal, true);
        dlg.carregarPaciente(paciente);
        dlg.setLocationRelativeTo(frmPrincipal);
        dlg.setVisible(true);
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
