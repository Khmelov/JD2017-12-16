package by.it.sevashko.jd01_15;

import java.io.BufferedReader;
import java.io.IOException;

public enum ReadState {
    OrdinaryText,
    CommentLine,
    MultiLineComment;

    public ReadState getState (BufferedReader br) throws IOException{
        br.mark(2);
        switch (this){
            case OrdinaryText:{
                if (br.read() == '/'){
                    int nextChar = br.read();
                    if (nextChar == '/'){ ;
                        return CommentLine;
                    }
                    else if (nextChar == '*'){
                        return MultiLineComment;
                    }
                }
                br.reset();
                return OrdinaryText;
            }
            case CommentLine:{
                if (br.read() == '\n'){
                    br.reset();
                    return OrdinaryText;
                } else {
                    br.reset();
                    return CommentLine;
                }
            }
            case MultiLineComment:{
                if (br.read() == '*'){
                    if (br.read() == '/'){
                        return OrdinaryText;
                    }
                }
                br.reset();
                return MultiLineComment;
            }
        }
        return OrdinaryText;
    }
}
