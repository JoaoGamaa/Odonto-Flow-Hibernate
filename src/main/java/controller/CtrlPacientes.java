package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.Paciente;

public class CtrlPacientes {

    private static CtrlPacientes instancia;

    private final List<Paciente> pacientes;
    private Paciente pacienteSelecionado;

    private CtrlPacientes() {
        pacientes = new ArrayList<>();
    }

    public static CtrlPacientes getInstancia() {
        if (instancia == null) {
            instancia = new CtrlPacientes();
        }
        return instancia;
    }

    public boolean cadastrarPaciente(Paciente paciente) {
        if (paciente == null || paciente.getNome() == null || paciente.getNome().isBlank()) {
            return false;
        }

        for (Paciente cadastrado : pacientes) {
            if (!cadastrado.getCpfNumerico().isBlank()
                    && cadastrado.getCpfNumerico().equals(paciente.getCpfNumerico())) {
                return false;
            }
        }

        pacientes.add(paciente);
        pacienteSelecionado = paciente;
        return true;
    }

    public List<Paciente> getPacientes() {
        return Collections.unmodifiableList(pacientes);
    }

    public boolean possuiPacientes() {
        return !pacientes.isEmpty();
    }

    public Paciente buscarPorNome(String nome) {
        for (Paciente paciente : pacientes) {
            if (paciente.getNome().equalsIgnoreCase(nome)) {
                return paciente;
            }
        }
        return null;
    }

    public Paciente buscarPorCpf(String cpf) {
        String cpfNumerico = cpf == null ? "" : cpf.replaceAll("\\D", "");
        for (Paciente paciente : pacientes) {
            if (paciente.getCpfNumerico().equals(cpfNumerico)) {
                return paciente;
            }
        }
        return null;
    }

    public Paciente getPacienteSelecionado() {
        return pacienteSelecionado;
    }

    public void setPacienteSelecionado(Paciente pacienteSelecionado) {
        this.pacienteSelecionado = pacienteSelecionado;
    }
}
