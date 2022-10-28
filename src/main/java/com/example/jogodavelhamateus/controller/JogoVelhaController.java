package com.example.jogodavelhamateus.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.action.Action;

import java.util.List;
import java.util.stream.Collectors;

public class JogoVelhaController {

    @FXML
    private Button btn00;

    @FXML
    private Button btn01;

    @FXML
    private Button btn02;

    @FXML
    private Button btn10;

    @FXML
    private Button btn11;

    @FXML
    private Button btn12;

    @FXML
    private Button btn20;

    @FXML
    private Button btn21;

    @FXML
    private Button btn22;

    @FXML
    private Label messageLabel;

    private String player;

    List<Button> botoes;

    @FXML
    public void initialize() {
        player = "X";
        messageLabel.setDisable(true);
        mapeiaLista();
    }

    @FXML
    void clicaBtn(ActionEvent event) {
        Button button = ((Button) event.getSource());

        if (button.getText().isBlank()){
            button.setText(player);
            trocaPlayer(player);
            messageLabel.setText("Próximo jogador: " + player);
            verificaVitoria(button);
        }
    }

    @FXML
    void reiniciaJogo(MouseEvent event) {
        botoes.forEach(button -> {
            button.setText("");
            button.setDisable(false);
        });
        messageLabel.setText("Clique em uma posição para iniciar");
        messageLabel.setDisable(true);
    }

    private void verificaVitoria(Button button) {
        if (igual(btn00, btn01, btn02)){
            fimDeJogo(btn00.getText());
            return;
        }
        if (igual(btn00, btn11, btn22)){
            fimDeJogo(btn00.getText());
            return;
        }
        if (igual(btn00, btn10, btn20)){
            fimDeJogo(btn00.getText());
            return;
        }
        if (igual(btn01, btn11, btn21)){
            fimDeJogo(btn01.getText());
            return;
        }
        if (igual(btn02, btn12, btn22)){
            fimDeJogo(btn02.getText());
            return;
        }
        if (igual(btn10, btn11, btn12)){
            fimDeJogo(btn10.getText());
            return;
        }
        if (igual(btn20, btn21, btn22)){
            fimDeJogo(btn20.getText());
            return;
        }
        if (igual(btn20, btn11, btn02)){
            fimDeJogo(btn20.getText());
            return;
        }
        verificaEmpate();
    }

    private void verificaEmpate() {
        List<Button> lista = botoes.stream().filter(button -> button.getText().equals(""))
                .collect(Collectors.toList());
        if (lista.isEmpty()){
            empatou();
        }
    }

    private void empatou() {
        botoes.forEach(button -> button.setDisable(true));
        messageLabel.setText("Empate :("+ "\n" + "Clique aqui para reiniciar");
        messageLabel.setDisable(false);
    }

    private void fimDeJogo(String vencedor) {
        botoes.forEach(button -> button.setDisable(true));
        messageLabel.setText("Vencedor: " + vencedor + "\n" + "Clique aqui para reiniciar");
        messageLabel.setDisable(false);
    }

    private boolean igual(Button btn1, Button btn2, Button btn3) {
        return !btn1.getText().isBlank()
                && btn1.getText().equals(btn2.getText())
                && btn3.getText().equals(btn2.getText());
    }

    private void mapeiaLista() {
        botoes = List.of(btn00, btn01, btn02, btn10, btn11, btn12, btn20, btn21, btn22);
    }

    private void trocaPlayer(String player) {
        this.player = (player.equals("X")) ? "O" : "X";
    }

}
