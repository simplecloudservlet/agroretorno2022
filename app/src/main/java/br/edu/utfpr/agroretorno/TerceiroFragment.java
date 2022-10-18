package br.edu.utfpr.agroretorno;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;

import java.text.DecimalFormat;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import br.edu.utfpr.agroretorno.databinding.FragmentTerceiroBinding;

public class TerceiroFragment extends Fragment {

    private FragmentTerceiroBinding binding;

    private LinearLayout agroretorno_view;

    private Button botao_limpar, botao_repetir, botao_calcular, botao_avancar;

    private EditText [] lista_receita, lista_custo, lista_fc, lista_desconto;
    private TextView[] lista_ano;

    private double [] fc, dp;
    private static final String TAG_TIR = "TIR";

    private int prazo_anos;
    private double investimento, juros;
    private int maximo_anos;

    private String payback;

    private Bundle bundle;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentTerceiroBinding.inflate(inflater, container, false);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bundle = new Bundle();
        bundle = this.getArguments();

        if(bundle != null){
            //binding.receita1.setText(bundle.getString("prazo_anos"));
            //binding.receita2.setText(bundle.getString("investimento"));
            //binding.receita3.setText(bundle.getString("juros"));
            //binding.receita4.setText(bundle.getString("maximo_anos"));
            try {
                prazo_anos = Integer.valueOf(bundle.getString("prazo_anos"));
                investimento = Double.valueOf(bundle.getString("investimento").replace(',','.'));
                juros = Double.valueOf(bundle.getString("juros").replace(',','.'));
                maximo_anos = Integer.valueOf(bundle.getString("maximo_anos").replace(',','.'));

                juros /= 100;

                lista_ano = new TextView[maximo_anos + 1];
                lista_receita = new EditText[maximo_anos + 1];
                lista_custo = new EditText[maximo_anos + 1];
                lista_fc = new EditText[maximo_anos + 1];
                lista_desconto = new EditText[maximo_anos + 1];

                int i = 1;
                //Linha1
                lista_ano[i] = (TextView) binding.ano1;
                lista_receita[i] = (EditText) binding.receita1;
                lista_custo[i] = (EditText) binding.custo1;
                lista_fc[i] = (EditText) binding.fc1;
                lista_fc[i].setEnabled(false);
                lista_desconto[i] = (EditText) binding.desconto1;
                lista_desconto[i].setEnabled(false);
                i++;

                //Linha2
                lista_ano[i] = (TextView) binding.ano2;
                lista_receita[i] = (EditText) binding.receita2;
                lista_custo[i] = (EditText) binding.custo2;
                lista_fc[i] = (EditText) binding.fc2;
                lista_fc[i].setEnabled(false);
                lista_desconto[i] = (EditText) binding.desconto2;
                lista_desconto[i].setEnabled(false);
                i++;

                //Linha3
                lista_ano[i] = (TextView) binding.ano3;
                lista_receita[i] = (EditText) binding.receita3;
                lista_custo[i] = (EditText) binding.custo3;
                lista_fc[i] = (EditText) binding.fc3;
                lista_fc[i].setEnabled(false);
                lista_desconto[i] = (EditText) binding.desconto3;
                lista_desconto[i].setEnabled(false);
                i++;

                //Linha4
                lista_ano[i] = (TextView) binding.ano4;
                lista_receita[i] = (EditText) binding.receita4;
                lista_custo[i] = (EditText) binding.custo4;
                lista_fc[i] = (EditText) binding.fc4;
                lista_fc[i].setEnabled(false);
                lista_desconto[i] = (EditText) binding.desconto4;
                lista_desconto[i].setEnabled(false);
                i++;

                //Linha5
                lista_ano[i] = (TextView) binding.ano5;
                lista_receita[i] = (EditText) binding.receita5;
                lista_custo[i] = (EditText) binding.custo5;
                lista_fc[i] = (EditText) binding.fc5;
                lista_fc[i].setEnabled(false);
                lista_desconto[i] = (EditText) binding.desconto5;
                lista_desconto[i].setEnabled(false);
                i++;

                //Linha6
                lista_ano[i] = (TextView) binding.ano6;
                lista_receita[i] = (EditText) binding.receita6;
                lista_custo[i] = (EditText) binding.custo6;
                lista_fc[i] = (EditText) binding.fc6;
                lista_fc[i].setEnabled(false);
                lista_desconto[i] = (EditText) binding.desconto6;
                lista_desconto[i].setEnabled(false);
                i++;

                //Linha7
                lista_ano[i] = (TextView) binding.ano7;
                lista_receita[i] = (EditText) binding.receita7;
                lista_custo[i] = (EditText) binding.custo7;
                lista_fc[i] = (EditText) binding.fc7;
                lista_fc[i].setEnabled(false);
                lista_desconto[i] = (EditText) binding.desconto7;
                lista_desconto[i].setEnabled(false);
                i++;

                //Linha8
                lista_ano[i] = (TextView) binding.ano8;
                lista_receita[i] = (EditText) binding.receita8;
                lista_custo[i] = (EditText) binding.custo8;
                lista_fc[i] = (EditText) binding.fc8;
                lista_fc[i].setEnabled(false);
                lista_desconto[i] = (EditText) binding.desconto8;
                lista_desconto[i].setEnabled(false);
                i++;

                //Linha9
                lista_ano[i] = (TextView) binding.ano9;
                lista_receita[i] = (EditText) binding.receita9;
                lista_custo[i] = (EditText) binding.custo9;
                lista_fc[i] = (EditText) binding.fc9;
                lista_fc[i].setEnabled(false);
                lista_desconto[i] = (EditText) binding.desconto9;
                lista_desconto[i].setEnabled(false);
                i++;

                //Linha10
                lista_ano[i] = (TextView) binding.ano10;
                lista_receita[i] = (EditText) binding.receita10;
                lista_custo[i] = (EditText) binding.custo10;
                lista_fc[i] = (EditText) binding.fc10;
                lista_fc[i].setEnabled(false);
                lista_desconto[i] = (EditText) binding.desconto10;
                lista_desconto[i].setEnabled(false);
                i++;

                //Linha11
                lista_ano[i] = (TextView) binding.ano11;
                lista_receita[i] = (EditText) binding.receita11;
                lista_custo[i] = (EditText) binding.custo11;
                lista_fc[i] = (EditText) binding.fc11;
                lista_fc[i].setEnabled(false);
                lista_desconto[i] = (EditText) binding.desconto11;
                lista_desconto[i].setEnabled(false);
                i++;

                //Linha12
                lista_ano[i] = (TextView) binding.ano12;
                lista_receita[i] = (EditText) binding.receita12;
                lista_custo[i] = (EditText) binding.custo12;
                lista_fc[i] = (EditText) binding.fc12;
                lista_fc[i].setEnabled(false);
                lista_desconto[i] = (EditText) binding.desconto12;
                lista_desconto[i].setEnabled(false);
                i++;

                //Linha13
                lista_ano[i] = (TextView) binding.ano13;
                lista_receita[i] = (EditText) binding.receita13;
                lista_custo[i] = (EditText) binding.custo13;
                lista_fc[i] = (EditText) binding.fc13;
                lista_fc[i].setEnabled(false);
                lista_desconto[i] = (EditText) binding.desconto13;
                lista_desconto[i].setEnabled(false);
                i++;

                //Linha14
                lista_ano[i] = (TextView) binding.ano14;
                lista_receita[i] = (EditText) binding.receita14;
                lista_custo[i] = (EditText) binding.custo14;
                lista_fc[i] = (EditText) binding.fc14;
                lista_fc[i].setEnabled(false);
                lista_desconto[i] = (EditText) binding.desconto14;
                lista_desconto[i].setEnabled(false);
                i++;

                //Linha15
                lista_ano[i] = (TextView) binding.ano15;
                lista_receita[i] = (EditText) binding.receita15;
                lista_custo[i] = (EditText) binding.custo15;
                lista_fc[i] = (EditText) binding.fc15;
                lista_fc[i].setEnabled(false);
                lista_desconto[i] = (EditText) binding.desconto15;
                lista_desconto[i].setEnabled(false);
                i++;

                //Linha16
                lista_ano[i] = (TextView) binding.ano16;
                lista_receita[i] = (EditText) binding.receita16;
                lista_custo[i] = (EditText) binding.custo16;
                lista_fc[i] = (EditText) binding.fc16;
                lista_fc[i].setEnabled(false);
                lista_desconto[i] = (EditText) binding.desconto16;
                lista_desconto[i].setEnabled(false);
                i++;

                //Linha17
                lista_ano[i] = (TextView) binding.ano17;
                lista_receita[i] = (EditText) binding.receita17;
                lista_custo[i] = (EditText) binding.custo17;
                lista_fc[i] = (EditText) binding.fc17;
                lista_fc[i].setEnabled(false);
                lista_desconto[i] = (EditText) binding.desconto17;
                lista_desconto[i].setEnabled(false);
                i++;

                //Linha18
                lista_ano[i] = (TextView) binding.ano18;
                lista_receita[i] = (EditText) binding.receita18;
                lista_custo[i] = (EditText) binding.custo18;
                lista_fc[i] = (EditText) binding.fc18;
                lista_fc[i].setEnabled(false);
                lista_desconto[i] = (EditText) binding.desconto18;
                lista_desconto[i].setEnabled(false);
                i++;

                //Linha19
                lista_ano[i] = (TextView) binding.ano19;
                lista_receita[i] = (EditText) binding.receita19;
                lista_custo[i] = (EditText) binding.custo19;
                lista_fc[i] = (EditText) binding.fc19;
                lista_fc[i].setEnabled(false);
                lista_desconto[i] = (EditText) binding.desconto19;
                lista_desconto[i].setEnabled(false);
                i++;

                //Linha20
                lista_ano[i] = (TextView) binding.ano20;
                lista_receita[i] = (EditText) binding.receita20;
                lista_custo[i] = (EditText) binding.custo20;
                lista_fc[i] = (EditText) binding.fc20;
                lista_fc[i].setEnabled(false);
                lista_desconto[i] = (EditText) binding.desconto20;
                lista_desconto[i].setEnabled(false);
                i++;

                //Linha21
                lista_ano[i] = (TextView) binding.ano21;
                lista_receita[i] = (EditText) binding.receita21;
                lista_custo[i] = (EditText) binding.custo21;
                lista_fc[i] = (EditText) binding.fc21;
                lista_fc[i].setEnabled(false);
                lista_desconto[i] = (EditText) binding.desconto21;
                lista_desconto[i].setEnabled(false);
                i++;

                //Linha22
                lista_ano[i] = (TextView) binding.ano22;
                lista_receita[i] = (EditText) binding.receita22;
                lista_custo[i] = (EditText) binding.custo22;
                lista_fc[i] = (EditText) binding.fc22;
                lista_fc[i].setEnabled(false);
                lista_desconto[i] = (EditText) binding.desconto22;
                lista_desconto[i].setEnabled(false);
                i++;

                //Linha23
                lista_ano[i] = (TextView) binding.ano23;
                lista_receita[i] = (EditText) binding.receita23;
                lista_custo[i] = (EditText) binding.custo23;
                lista_fc[i] = (EditText) binding.fc23;
                lista_fc[i].setEnabled(false);
                lista_desconto[i] = (EditText) binding.desconto23;
                lista_desconto[i].setEnabled(false);
                i++;

                //Linha24
                lista_ano[i] = (TextView) binding.ano24;
                lista_receita[i] = (EditText) binding.receita24;
                lista_custo[i] = (EditText) binding.custo24;
                lista_fc[i] = (EditText) binding.fc24;
                lista_fc[i].setEnabled(false);
                lista_desconto[i] = (EditText) binding.desconto24;
                lista_desconto[i].setEnabled(false);
                i++;

                //Libera apenas os campos do 'prazo_anos'
                i = 1;
                while (i <= prazo_anos) {
                    lista_ano[i].setVisibility(getView().VISIBLE);
                    lista_receita[i].setVisibility(getView().VISIBLE);
                    lista_custo[i].setVisibility(getView().VISIBLE);
                    lista_fc[i].setVisibility(getView().VISIBLE);
                    i++;
                }

                //Oculta os demais campos
                while (i <= maximo_anos) {
                    lista_ano[i].setVisibility(getView().INVISIBLE);
                    lista_receita[i].setVisibility(getView().INVISIBLE);
                    lista_custo[i].setVisibility(getView().INVISIBLE);
                    lista_fc[i].setVisibility(getView().INVISIBLE);
                    lista_desconto[i].setVisibility(getView().INVISIBLE);
                    i++;
                }

                //binding.botaoReiniciar = (Button) binding.botao_reiniciar);
                binding.botaoReiniciar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        limpar();
                    }
                });

                //botao_repetir = (Button) agroretorno_view.findViewById(R.id.botao_repetir);
                binding.botaoRepetir.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        repetir();
                        calcular();
                    }
                });

                //botao_calcular = (Button) agroretorno_view.findViewById(R.id.botao_calcular);
                binding.botaoCalcular.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        calcular();
                    }
                });

                //botao_avancar = (Button) agroretorno_view.findViewById(R.id.botao_avancar);
                binding.botaoAvancar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        calcular();

                        NavHostFragment.findNavController(TerceiroFragment.this)
                                .navigate(R.id.action_TerceiroFragment_to_QuartoFragment, bundle);

                    }
                });
            } catch (Exception e){
                Log.i(TAG_TIR,"Campos vazios ainda nao informados.", e);
            }

        }

       /* binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(TerceiroFragment.this)
                        .navigate(R.id.action_SecondFragment_to_SecondFragment);
            }
        });*/


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void limpar(){
        int i=1;
        while(i<=prazo_anos) {
            lista_fc[i].setText("0");
            lista_receita[i].setText("0");
            lista_custo[i].setText("0");
            lista_desconto[i].setText("0");
            i++;
        }
    }

    public void repetir(){
        int i=1;
        while(i<=prazo_anos) {
            lista_receita[i].setText(lista_receita[1].getText().toString().replace(',','.'));
            lista_custo[i].setText(lista_custo[1].getText().toString().replace(',','.'));
            lista_desconto[i].setText(lista_desconto[1].getText().toString().replace(',','.'));
            i++;
        }
    }

    public void calcular(){

        try {
            DecimalFormat f = new DecimalFormat("##.00");
            double soma = 0.0;
            int i = 0;

            fc = new double[prazo_anos + 1];
            dp = new double[prazo_anos + 1];

            double r, c;

            fc[0] = 0;
            dp[0] = 0;

            //////
            //Taxa de Desconto
            double[] desconto = new double[prazo_anos + 1]; //+1 pq primeiro ano nao tem desconto
            double[] potencia = new double[prazo_anos + 1];

            potencia[0] = 1 + juros;
            i=1;
            while (i <= prazo_anos) {
                potencia[i] = Math.pow(potencia[0], i);
                Log.i(TAG_TIR, "Potencia " + i + " " + potencia[i]);
                i++;
            }
            desconto[0] = 0;
            soma = 0;
            /////////

            i = 1;
            while (i <= prazo_anos) {
                //Fluxo Caixa
                r = Double.valueOf(lista_receita[i].getText().toString().replace(',','.'));
                c = Double.valueOf(lista_custo[i].getText().toString().replace(',','.'));
                fc[i] = r - c;
                dp[i] = fc[i] / Math.pow(1 + juros, i + 1);

                lista_fc[i].setText(f.format(fc[i]).toString().replace(',','.'));
                Log.i(TAG_TIR, "DP: " + i + " " + dp[i]);

                //Desconto
                desconto[i] = fc[i] / potencia[i];
                soma += desconto[i];
                lista_desconto[i].setText(Double.parseDouble(f.format(desconto[i]).replace(',','.'))+"");
                Log.i(TAG_TIR, "Desconto " + i + " " + desconto[i]);

                i++;
            }
            bundle.putString("somadescontos", f.format(soma) + "");

            //Soma do Fluxo de Caixa
            /*i = 0;
            while (i <= prazo_anos) {
                soma += dp[i];
                i++;
            }
            bundle.putString("somafc", f.format(soma));
*/

            //VPL
            soma = 0.0;
            for (i = 1; i <= prazo_anos; i++)
                //soma += fc[i] / Math.pow(1 + juros, i + 1);
                soma += desconto[i];

            double vpl = -investimento + soma;


            //bundle.putString("prazo_anos", prazo_anos + "");
            Log.i(TAG_TIR, "VPL: " + vpl);
            bundle.putString("vpl", f.format(vpl));

            //IL
            //soma = 0.0;
            //for (i = 1; i <=prazo_anos; i++)
            //    soma += dp[i];
            double il = soma / investimento;

            Log.i(TAG_TIR, "IL: " + i + " " + il);
            bundle.putString("il", f.format(il));

            ////////
            double tir = 0.00;
            double vp = investimento;

            while (vp > 0) {
                tir += 0.0001;
                i = 1;
                soma = 0.0;
                while (i <= prazo_anos) {
                    soma += fc[i] / Math.pow(1 + tir, i);
                    i++;
                }
                vp = -investimento + soma;
                //Log.i(TAG_TIR, "VP---->: " + vp + " TIR: " + tir);
            }

            Log.i(TAG_TIR, "TIR: " + tir);
            bundle.putString("tir", f.format(tir * 100));

            //Payback
            String payback="0";
            if(il>1) {

                double retorno = -investimento;
                double[] vd = new double[prazo_anos + 1];

                i = 0;
                while (retorno < 0 && i <= prazo_anos) {
                    retorno += desconto[i];
                    vd[i] = retorno; //guarda o valor
                    Log.i(TAG_TIR, "Payback " + i + " " + retorno);
                    i++;
                }
                i--;
                int ano = i - 1;
                double valorAno = desconto[i];
                double valorMes = valorAno / 12;
                double mes = vd[ano] / valorMes;
                double dia = (6 + mes) * 30;

                //Minor adjusts
                dia = (int) Math.ceil(Math.abs(dia%365)%30);
                //mes = (int) Math.round(Math.abs((dia%365)/30));
                mes = (int) Math.round(Math.abs(mes));

                payback = ano + " ano(s), " + (int) mes + " mes(es), " + (int) dia + " dia(s)";
                Log.i(TAG_TIR, payback);
            }

            bundle.putString("payback",payback);

        } catch (NumberFormatException e){
            Log.i(TAG_TIR,"Campos vazios ainda nao informados.", e);
        }

    }

}