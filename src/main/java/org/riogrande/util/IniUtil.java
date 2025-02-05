package org.riogrande.util;

import java.io.File;
import java.io.IOException;
import org.ini4j.Ini;
import org.ini4j.InvalidFileFormatException;

public class IniUtil {

    private File arquivo;
    private Ini ini;

    public IniUtil(String arquivoINI) throws IOException {
        this.arquivo = new File(arquivoINI);
    }

    // Método para obter o valor de uma chave em uma seção
    public String getINI(String tag, String chave) throws InvalidFileFormatException, IOException {
        ini = new Ini(this.arquivo);
        // Recuperando o valor da chave na seção
        return ini.get(tag, chave);
    }

}
