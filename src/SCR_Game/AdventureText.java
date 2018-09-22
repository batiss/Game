
package SCR_Game;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdventureText implements Runnable{
    
    private Socket client;
    
    public AdventureText(Socket client){
        this.client = client;
    }
    
    @Override
    public void run() {
        try {
            Scanner read = new Scanner(this.client.getInputStream());
            PrintWriter write = new PrintWriter(this.client.getOutputStream(), true);
            
            write.println("A CAVERNA /n/n"
                    + "Press 1 para continuar \t"
                    + "Pree 0 para sair");
            
            while (true){
                String s = read.nextLine().toUpperCase();
                if(s.equalsIgnoreCase("0")){
                    break;
                } else{
                    switch (s){
                        case "1":
                            write.println("Você está em uma caverna e vê dois buracos que podem ser escalados. \t"
                                    + "O que você vai fazer??? \t"
                                    + "Press 1A para escalar o buraco da esquerda\t"
                                    + "Press 2A para escalar o buraco da direita");
                                break;
                            
                        case "1A":
                            write.println("Você vê uma lagoa na sala mal iluminada. \t"
                                    + "Há uma luz vindo de dentro da lagoa.\t"
                                    + "Há também outro buraco para escalar.\t"
                                    + "Press 1B para mergulhar na lagoa \t"
                                    + "Press 2B para escalar o outro buraco");
                            break;
                            
                        case "2A":
                            write.println("Você se encontra em um abismo vertical. Você pode subir ou descer. \t"
                                    + "Press 3A para subir \t"
                                    + "Press 4A para descer");
                            break;
                            
                        case "1B":
                            write.println("Você mergulha profundamente e através de um buraco submerso "
                                    + "que o leva a outra sala da caverna quando você submerge.\t"
                                    + "Press 1C para sair da agua");
                            break;
                            
                        case "2B":
                            write.println("");
                            break;
                            
                        case "1C":
                            write.println("A escuridão nesta sala estão ficando mais forte e "
                                    + "você começa a gritar para ver se o eco lhe "
                                    + "dirá o tamanho do espaço em que você se encontra. \t"
                                    + "Press 1D para continuar gritando \t"
                                    + "Press 2D para andar pelo escuro");
                            break;
                            
                        case "2C":
                            write.println();
                            break;
                            
                        case "1D":
                            write.println("Depois de gritar por algum tempo você ouve algo gritar de volta, "
                                    + "e depois disso tudo ficou eternamente escuro. YOU DIED!!! \t"
                                    + "ISSO NÂO É BOM ---> Press 1Z");
                            break;
                        
                        case "3A":
                            write.println("Você não pode dizer se está vendo fantasmas ou neblina,"
                                    + " mas é difícil ver através dessas nuvens em movimento. "
                                    + "Você sente o seu caminho ao longo da parede e pensa que"
                                    + " encontrou uma superfície plana e lisa.\t"
                                    + "Press 3B para examinar a superfície \t"
                                    + "Press 4B para continuar procurando.");
                            break;
                            
                        case "3B":
                            write.println("Você examina a superfície e descobre um botão redondo. \t"
                                    + "Você pressiona o botão. Uma porta secreta se abre. \t"
                                    + "Você entra na sala com um piso plano e paredes.\t"
                                    + "Tem um brilho laranja iluminando-o.\t"
                                    + "Você achou ---> Press 2Z?");
                            break;
                            
                        case "3C":
                            write.println("");
                            break;
                            
                        case "4A":
                            write.println("");
                            break;
                            
                        case "4B":
                            write.println("Você continua caminhando até que o solo embaixo ceda e seu"
                                    + " estômago se levante e o vento passe por seus ouvidos.\t"
                                    + "ISSO NÂO É BOM ---> Press 1Z");
                            break;
                            
                        case "4C":
                            write.println("");
                            break;
                            
                        
                        case "1Z":
                            write.println("Os ecos do seu último grito foram tudo o que você ouviu antes"
                                    + " que a escuridão eterna o atingisse."
                                    + " YOU DIED!!! \t"
                                    + "Press 1 para jogar de novo\t"
                                    + "Press 0 para sair");
                            break;
                            
                        case "2Z":
                            write.println("Quando seus olhos se ajustam, você começa a ver que existem "
                                    + "instrumentos científicos na sala. "
                                    + "Você encontra a máquina do tempo que você precisa! \t"
                                    + "Press 1 para jogar de novo\t"
                                    + "Press 0 para sair");
                            break;
                    }
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(AdventureText.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

