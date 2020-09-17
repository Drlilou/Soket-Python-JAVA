import socket

def create_model():
    model=Sequential()
    model.add(layers.Embedding(VOCAB_LENGTH, output_dim=128 ))
    model.add(layers.LSTM(units=128,return_sequences=True))
    model.add(layers.LSTM(units=32))
    model.add(layers.Flatten())
    model.add(layers.Dense(8))
    model.add(layers.Dropout(0.25))
    model.add(layers.Dense(1, activation="sigmoid"))
    opt = keras.optimizers.Adam(learning_rate=0.01)
    model.compile(optimizer=opt, loss="binary_crossentropy", 
     metrics=['accuracy'])
    return model
"""
import tensorflow_hub as hub
import bert
BertTokenizer = bert.bert_tokenization.FullTokenizer
bert_layer = hub.KerasLayer("https://tfhub.dev/tensorflow/bert_en_cased_L-12_H-768_A-12/1",
                            trainable=False)
vocabulary_file = bert_layer.resolved_object.vocab_file.asset_path.numpy()
to_lower_case = bert_layer.resolved_object.do_lower_case.numpy()
tokenizer = BertTokenizer(vocabulary_file, to_lower_case)
def tokenize(text):
    return tokenizer.convert_tokens_to_ids(tokenizer.tokenize(text))

weights_path="model.hdf5"
model = create_model()
model.load_weights(weights_path)
"""
HOST = "localhost"
PORT = 8888
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)


try:
    s.bind(('', PORT))
except socket.error as err:
    print('Bind failed. Error Code : ' .format(err))
s.listen(10)


def receive_message(s):
    conn, addr = s.accept()
    
   
    data = conn.recv(1024)
    data=data.decode(encoding='UTF-8')
    #seq=[tokenize(data)]
    #pred = model.predict(seq)
 
    #pred =np.round(pred)
    pred=0
    if pred==0 :
         #print('negative')
         conn.send(bytes("0"+"\r\n",'UTF-8'))

    else :
         #print('positive')
         conn.send(bytes("1"+"\r\n",'UTF-8'))

   
while True:
    receive_message(s)