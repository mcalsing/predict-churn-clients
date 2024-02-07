import javax.swing.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main extends javax.swing.JFrame {

  public Main() {
    initComponents();
  }

  private boolean membroAtivo;
  private int idade;
  private String sexo;
  private int servicosAdquiridos;
  private String pais;
  private int saldo;
  private int salario;
  private int score;
  private int anosCliente;
  private boolean temCartao;

  private boolean validateInputs() {
    try {

      if (idadeField.getText() == "Idade") {
        returnLabel.setText("Erro: Preencha todos os campos.");
        return false;
      } else {
        idade = Integer.parseInt(idadeField.getText());
        if (idade < 18 || idade > 120) {
          returnLabel.setText("Erro: Idade deve ser entre 18 e 120 anos.");
          return false;
        }
      }

      if (!sexo.equals("Homem") && !sexo.equals("Mulher")) {
        returnLabel.setText("Erro: Preencha todos os campos.");
        return false;
      }

      if (!pais.equals("França") && !pais.equals("Espanha") && !pais.equals("Alemanha")) {
        returnLabel.setText("Erro: Preencha todos os campos.");
        return false;
      }

      if (salarioField.getText().equals("Salário")) {
        returnLabel.setText("Erro: Preencha todos os campos.");
        return false;
      } else {
        salario = Integer.parseInt(salarioField.getText());
      }

      if(saldoField.getText().equals("Saldo")) {
        returnLabel.setText("Erro: Preencha todos os campos.");
        return false;
      } else {
        saldo = Integer.parseInt(saldoField.getText());
      }

      if (scoreField.getText().equals("Score")) {
        returnLabel.setText("Erro: Preencha todos os campos.");
        return false;
      } else {
        score = Integer.parseInt(scoreField.getText());
      }

      if(anosClienteField.getText().equals("Anos de Cliente")) {
        returnLabel.setText("Erro: Preencha todos os campos.");
        return false;
      } else {
        anosCliente = Integer.parseInt(anosClienteField.getText());
      }

      if (servicosAdquiridosField.getText().equals("Serviços Adquiridos")) {
        returnLabel.setText("Erro: Preencha todos os campos.");
        return false;
      } else {
        servicosAdquiridos = Integer.parseInt(servicosAdquiridosField.getText());
      }

      return true;
    } catch (NumberFormatException e) {
      returnLabel.setText("Erro. Preencha os campos corretamente.");
      return false;
    }
  }

  @SuppressWarnings("unchecked")
  private void initComponents() {

    jPanel2 = new javax.swing.JPanel();
    jPanel1 = new javax.swing.JPanel();
    infoLabel = new javax.swing.JLabel();
    returnLabel = new javax.swing.JLabel();
    jPanel3 = new javax.swing.JPanel();
    formLabel = new javax.swing.JLabel();
    idadeField = new javax.swing.JTextField();
    saldoField = new javax.swing.JTextField();
    salarioField = new javax.swing.JTextField();
    scoreField = new javax.swing.JTextField();
    anosClienteField = new javax.swing.JTextField();
    cartaoAtivoBox = new javax.swing.JCheckBox();
    confirmarBtn = new javax.swing.JButton();
    esvaziarBtn = new javax.swing.JButton();
    sexoBox = new javax.swing.JComboBox<>();
    paisBox = new javax.swing.JComboBox<>();
    membroAtivoBox = new javax.swing.JCheckBox();
    servicosAdquiridosField = new javax.swing.JTextField();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setBackground(new java.awt.Color(241, 241, 241));

    jPanel2.setBackground(new java.awt.Color(241, 241, 241));

    jPanel1.setBackground(new java.awt.Color(255, 255, 255));
    jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 2));

    infoLabel.setFont(new java.awt.Font("Liberation Sans", 1, 12)); // NOI18N
    infoLabel.setForeground(new java.awt.Color(0, 0, 0));
    infoLabel.setText("Quadro de informações");

    returnLabel.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
    returnLabel.setForeground(new java.awt.Color(0, 0, 0));
    returnLabel.setText("As informações serão apresentadas aqui");
    returnLabel.setToolTipText("");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(returnLabel)
                .addGap(142, 142, 142))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoLabel)
                .addGap(96, 96, 96)
                .addComponent(returnLabel)
                .addContainerGap(97, Short.MAX_VALUE))
    );

    jPanel3.setBackground(new java.awt.Color(255, 255, 255));
    jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 2));

    formLabel.setFont(new java.awt.Font("Liberation Sans", 1, 12)); // NOI18N
    formLabel.setForeground(new java.awt.Color(0, 0, 0));
    formLabel.setText("Formulário");

    idadeField.setBackground(new java.awt.Color(255, 255, 255));
    idadeField.setFont(new java.awt.Font("Liberation Sans", 0, 11)); // NOI18N
    idadeField.setText("Idade");
    idadeField.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(java.awt.event.FocusEvent evt) {
        idadeFieldFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt) {
        idadeFieldFocusLost(evt);
      }
    });
    idadeField.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        idadeFieldActionPerformed(evt);
      }
    });
    idadeField.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        idadeFieldKeyTyped(evt);
      }
    });

    saldoField.setBackground(new java.awt.Color(255, 255, 255));
    saldoField.setFont(new java.awt.Font("Liberation Sans", 0, 11)); // NOI18N
    saldoField.setText("Saldo");
    saldoField.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(java.awt.event.FocusEvent evt) {
        saldoFieldFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt) {
        saldoFieldFocusLost(evt);
      }
    });
    saldoField.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        saldoFieldActionPerformed(evt);
      }
    });
    saldoField.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        saldoFieldKeyTyped(evt);
      }
    });

    salarioField.setBackground(new java.awt.Color(255, 255, 133));
    salarioField.setFont(new java.awt.Font("Liberation Sans", 0, 11)); // NOI18N
    salarioField.setText("Salário");
    salarioField.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(java.awt.event.FocusEvent evt) {
        salarioFieldFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt) {
        salarioFieldFocusLost(evt);
      }
    });
    salarioField.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        salarioFieldActionPerformed(evt);
      }
    });
    salarioField.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        salarioFieldKeyTyped(evt);
      }
    });

    scoreField.setBackground(new java.awt.Color(255, 255, 255));
    scoreField.setFont(new java.awt.Font("Liberation Sans", 0, 11)); // NOI18N
    scoreField.setText("Score");
    scoreField.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(java.awt.event.FocusEvent evt) {
        scoreFieldFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt) {
        scoreFieldFocusLost(evt);
      }
    });
    scoreField.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        scoreFieldActionPerformed(evt);
      }
    });
    scoreField.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        scoreFieldKeyTyped(evt);
      }
    });

    anosClienteField.setBackground(new java.awt.Color(255, 255, 255));
    anosClienteField.setFont(new java.awt.Font("Liberation Sans", 0, 11)); // NOI18N
    anosClienteField.setText("Anos de Cliente");
    anosClienteField.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(java.awt.event.FocusEvent evt) {
        anosClienteFieldFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt) {
        anosClienteFieldFocusLost(evt);
      }
    });
    anosClienteField.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        anosClienteFieldActionPerformed(evt);
      }
    });
    anosClienteField.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        anosClienteFieldKeyTyped(evt);
      }
    });

    cartaoAtivoBox.setFont(new java.awt.Font("Liberation Sans", 0, 11)); // NOI18N
    cartaoAtivoBox.setText("Cartão?");
    cartaoAtivoBox.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cartaoAtivoBoxActionPerformed(evt);
      }
    });

    confirmarBtn.setBackground(new java.awt.Color(235, 235, 235));
    confirmarBtn.setFont(new java.awt.Font("Liberation Sans", 0, 10)); // NOI18N
    confirmarBtn.setForeground(new java.awt.Color(0, 0, 0));
    confirmarBtn.setText("Confirmar");
    confirmarBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
    confirmarBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        try {
          confirmarBtnActionPerformed(evt);
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    });

    esvaziarBtn.setBackground(new java.awt.Color(235, 235, 235));
    esvaziarBtn.setFont(new java.awt.Font("Liberation Sans", 0, 10)); // NOI18N
    esvaziarBtn.setForeground(new java.awt.Color(0, 0, 0));
    esvaziarBtn.setText("Esvaziar Campos");
    esvaziarBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
    esvaziarBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        esvaziarBtnActionPerformed(evt);
      }
    });

    sexoBox.setBackground(new java.awt.Color(255, 255, 255));
    sexoBox.setFont(new java.awt.Font("Liberation Sans", 0, 11)); // NOI18N
    sexoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sexo", "Homem", "Mulher" }));
    sexoBox.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        sexoBoxActionPerformed(evt);
      }
    });

    paisBox.setBackground(new java.awt.Color(255, 255, 255));
    paisBox.setFont(new java.awt.Font("Liberation Sans", 0, 11)); // NOI18N
    paisBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "País", "Alemanha", "Espanha", "França" }));
    paisBox.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        paisBoxActionPerformed(evt);
      }
    });

    membroAtivoBox.setFont(new java.awt.Font("Liberation Sans", 0, 11)); // NOI18N
    membroAtivoBox.setText("Membro Ativo?");
    membroAtivoBox.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        membroAtivoBoxActionPerformed(evt);
      }
    });

    servicosAdquiridosField.setBackground(new java.awt.Color(255, 255, 255));
    servicosAdquiridosField.setFont(new java.awt.Font("Liberation Sans", 0, 11)); // NOI18N
    servicosAdquiridosField.setText("Serviços Adquiridos");
    servicosAdquiridosField.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(java.awt.event.FocusEvent evt) {
        servicosAdquiridosFieldFocusGained(evt);
      }
      public void focusLost(java.awt.event.FocusEvent evt) {
        servicosAdquiridosFieldFocusLost(evt);
      }
    });
    servicosAdquiridosField.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        servicosAdquiridosFieldActionPerformed(evt);
      }
    });
    servicosAdquiridosField.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        servicosAdquiridosFieldKeyTyped(evt);
      }
    });

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(formLabel))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(anosClienteField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(idadeField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sexoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(servicosAdquiridosField, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addGap(12, 12, 12)
                                .addComponent(paisBox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(saldoField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(salarioField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scoreField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(membroAtivoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(cartaoAtivoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(confirmarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(esvaziarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
    );
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(formLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idadeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sexoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paisBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anosClienteField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(servicosAdquiridosField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saldoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salarioField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scoreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cartaoAtivoBox)
                    .addComponent(membroAtivoBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(esvaziarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
    );

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
    getContentPane().requestFocusInWindow();
    setLocationRelativeTo(null);
  }

  private void cartaoAtivoBoxActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
  }

  private void esvaziarBtnActionPerformed(java.awt.event.ActionEvent evt) {
    idadeField.setText("Idade");
    saldoField.setText("Saldo");
    salarioField.setText("Salário");
    scoreField.setText("Score");
    anosClienteField.setText("Anos de Cliente");
    servicosAdquiridosField.setText("Serviços Adquiridos");
    cartaoAtivoBox.setSelected(false);
    membroAtivoBox.setSelected(false);
    sexoBox.setSelectedIndex(0);
    paisBox.setSelectedIndex(0);
  }

  private void idadeFieldActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
  }

  private void servicosAdquiridosFieldActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
  }

  private void saldoFieldActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
  }

  private void salarioFieldActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
  }

  private void scoreFieldActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
  }

  private void anosClienteFieldActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
  }

  private void confirmarBtnActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
    membroAtivo = cartaoAtivoBox.isSelected();
    sexo = (String) sexoBox.getSelectedItem();
    pais = (String) paisBox.getSelectedItem();
    temCartao = cartaoAtivoBox.isSelected();

    if (!validateInputs()) {
      return; // Se a validação falhar, não envia a requisição
    }

    // Cria dados para enviar no corpo da requisição
    Map<String, List<Object>> data = new HashMap<>();
    // ArrayList<String> metricas = new ArrayList<String>();

    data.put("score_credito", Arrays.asList(score));
    data.put("pais", Arrays.asList(pais));
    data.put("sexo_biologico", Arrays.asList(sexo));
    data.put("idade", Arrays.asList(idade));
    data.put("anos_de_cliente", Arrays.asList(anosCliente));
    data.put("saldo", Arrays.asList(saldo));
    data.put("servicos_adquiridos", Arrays.asList(servicosAdquiridos));
    data.put("tem_cartao_credito", Arrays.asList(temCartao ? 1 : 0));
    data.put("membro_ativo", Arrays.asList(membroAtivo ? 1 : 0));
    data.put("salario_estimado", Arrays.asList(salario));

    // Converte os dados para JSON
    String requestBody = new ObjectMapper().writeValueAsString(data);

    // URL para o endpoint /predict
    URL url = new URL("http://localhost:5000/predict");

    // Criação da conexão HTTP
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

    // Configuração do método HTTP para POST
    connection.setRequestMethod("POST");

    // Habilitando envio de dados
    connection.setDoOutput(true);

    // Configurando cabeçalhos da requisição
    connection.setRequestProperty("Content-Type", "application/json");
    connection.setRequestProperty("Content-Length", String.valueOf(requestBody.length()));

    // Enviando dados no corpo da requisição
    try (OutputStream os = connection.getOutputStream()) {
      os.write(requestBody.getBytes(StandardCharsets.UTF_8));
    }

    // Obtendo a resposta do servidor
    int responseCode = connection.getResponseCode();
    System.out.println("Código de resposta: " + responseCode);

    // Lê a resposta do Python
    InputStream inputStream = connection.getInputStream();
    String responsePython = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
    Map<String,Object> result = new ObjectMapper().readValue(responsePython, HashMap.class);
    returnLabel.setText(String.valueOf(result.get("recall")));
  }

  private void sexoBoxActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
  }

  private void paisBoxActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
  }

  private void membroAtivoBoxActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
  }

  private void saldoFieldFocusGained(java.awt.event.FocusEvent evt) {
    if (saldoField.getText().equals("Saldo")) {
      saldoField.setText("");
    }
  }

  private void saldoFieldFocusLost(java.awt.event.FocusEvent evt) {
    if (saldoField.getText().equals("")) {
      saldoField.setText("Saldo");
    }
  }

  private void saldoFieldKeyTyped(java.awt.event.KeyEvent evt) {
    char c = evt.getKeyChar();

    if (!Character.isDigit(c)) {
      evt.consume();
    }

    if (saldoField.getText().length() >= 12) {
      evt.consume();
    }
  }

  private void salarioFieldFocusGained(java.awt.event.FocusEvent evt) {
    if (salarioField.getText().equals("Salário")) {
      salarioField.setText("");
    }
  }

  private void salarioFieldFocusLost(java.awt.event.FocusEvent evt) {
    if (salarioField.getText().equals("")) {
      salarioField.setText("Salário");
    }
  }

  private void salarioFieldKeyTyped(java.awt.event.KeyEvent evt) {
    char c = evt.getKeyChar();

    if (!Character.isDigit(c)) {
      evt.consume();
    }

    if (salarioField.getText().length() >= 8) {
      evt.consume();
    }
  }

  private void scoreFieldFocusGained(java.awt.event.FocusEvent evt) {
    if (scoreField.getText().equals("Score")) {
      scoreField.setText("");
    }
  }

  private void scoreFieldFocusLost(java.awt.event.FocusEvent evt) {
    if (scoreField.getText().equals("")) {
      scoreField.setText("Score");
    }
  }

  private void scoreFieldKeyTyped(java.awt.event.KeyEvent evt) {
    char c = evt.getKeyChar();

    if (!Character.isDigit(c)) {
      evt.consume();
    }

    if (scoreField.getText().length() >= 4) {
      evt.consume();
    }
  }

  private void anosClienteFieldFocusGained(java.awt.event.FocusEvent evt) {
    if (anosClienteField.getText().equals("Anos de Cliente")) {
      anosClienteField.setText("");
    }
  }

  private void anosClienteFieldFocusLost(java.awt.event.FocusEvent evt) {
    if (anosClienteField.getText().equals("")) {
      anosClienteField.setText("Anos de Cliente");
    }
  }

  private void anosClienteFieldKeyTyped(java.awt.event.KeyEvent evt) {
    char c = evt.getKeyChar();

    if (!Character.isDigit(c)) {
      evt.consume();
    }

    if (anosClienteField.getText().length() >= 3) {
      evt.consume();
    }
  }

  private void servicosAdquiridosFieldFocusGained(java.awt.event.FocusEvent evt) {
    if (servicosAdquiridosField.getText().equals("Serviços Adquiridos")) {
      servicosAdquiridosField.setText("");
    }
  }

  private void servicosAdquiridosFieldFocusLost(java.awt.event.FocusEvent evt) {
    if (servicosAdquiridosField.getText().equals("")) {
      servicosAdquiridosField.setText("Serviços Adquiridos");
    }
  }

  private void servicosAdquiridosFieldKeyTyped(java.awt.event.KeyEvent evt) {
    char c = evt.getKeyChar();

    if (!Character.isDigit(c)) {
      evt.consume();
    }

    if (servicosAdquiridosField.getText().length() >= 4) {
      evt.consume();
    }
  }

  private void idadeFieldFocusGained(java.awt.event.FocusEvent evt) {
    if (idadeField.getText().equals("Idade")) {
      idadeField.setText("");
    }
  }

  private void idadeFieldFocusLost(java.awt.event.FocusEvent evt) {
    if (idadeField.getText().equals("")) {
      idadeField.setText("Idade");
    }
  }

  private void idadeFieldKeyTyped(java.awt.event.KeyEvent evt) {
    char c = evt.getKeyChar();

    if (!Character.isDigit(c)) {
      evt.consume();
    }

    if (idadeField.getText().length() >= 3) {
      evt.consume();
    }
  }

  public static void main(String args[]) throws UnsupportedLookAndFeelException {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
      ex.printStackTrace();
    }

    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new Main().setVisible(true);
      }
    });
  }

  private javax.swing.JTextField anosClienteField;
  private javax.swing.JCheckBox cartaoAtivoBox;
  private javax.swing.JButton confirmarBtn;
  private javax.swing.JButton esvaziarBtn;
  private javax.swing.JLabel formLabel;
  private javax.swing.JTextField idadeField;
  private javax.swing.JLabel infoLabel;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JCheckBox membroAtivoBox;
  private javax.swing.JComboBox<String> paisBox;
  private javax.swing.JLabel returnLabel;
  private javax.swing.JTextField salarioField;
  private javax.swing.JTextField saldoField;
  private javax.swing.JTextField scoreField;
  private javax.swing.JTextField servicosAdquiridosField;
  private javax.swing.JComboBox<String> sexoBox;
}