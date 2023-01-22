import java.util.*;

public class Main {

    public static void main(String[] args) {
        //P1();
        //P2();
        //P3();
    }

    /*1.ArrayList
    -Métodos:
        -.add([indice],objeto) -> Añades un objeto del mismo tipo del arrayList / Si le pasas el indice añade a partir de dicho indice
        -.remove([indice],[objeto]) -> Elimina el objeto del arrayList busándolo automáticamente / Si el pasas el indice solo borra el indice no hace ambas / Si metes un objeto elimina el primero que encuentra
        -.size() -> Devuelve el numero de elementos, no posición
        -.isEmpty() -> Si está vacío
        -.contains(objeto) -> Devuelve true si está dentro
        -.clear() -> Se carga el arrayList
        -.addAll(arrayList/Colección) -> añade una colección a otra (Se debe pasar antes a AL)
        -.removeAll(objeto) -> Elimina todos los registros de dicho objeto
        -.retainAll(Colección /AL) -> Borra todos los elementos del AL existente en base a los contenidos de la colección pasada
        -.conainsAll(Colección /AL) -> Devuelve un true si contiene todos los objetos de la coleccion que le pasamos
        -.get(indice) -> Devuelve el objeto en dicho indice
        .toArray() -> Convierte to array
        .iterator -> lo convierte en listIterator


*/
    public static void P1(){

        System.out.println("Pruebas con ArrayList");
        ArrayList<String>lista=new ArrayList<>();
        ArrayList<String>lista2=new ArrayList<>();
        Scanner sc =new Scanner(System.in);

        lista2.add("Oso");
        lista2.add("Castor");


        for(int i=0;i<=4;i++){
            String cadena="";
            cadena=sc.next();
            lista.add(cadena);
        }
        //imprime la lista
        System.out.println(lista);
        System.out.println(lista.size());

        lista.add(3,"Tigreton");
        System.out.println(lista);

        lista.remove(3);

        lista.remove("Gato");
        System.out.println(lista);
        lista.addAll(lista2);
        System.out.println(lista);


        lista.clear();
        System.out.println(lista.isEmpty());

        lista.addAll(lista2);
        System.out.println(lista);







    }

    /*2.Iterator
    Se emplea para recorrer una coleccion

        -Métodos:
            -.next() -> Devuelve el siguiente objeto basandose en un indice imaginario
            -.hasNext() -> Devuelve true si hay un objeto a continuacion
            -.remove() -> Elimina sobre el indice en el que se encuentra

    Forma generalizada de recorrer colecciones

    */
    public static void P2(){

        Collection<String> coleccion = new ArrayList<>();


        coleccion.add("Gato");
        coleccion.add("Perro");

        //Para crear un iterator
        Iterator it = coleccion.iterator();
        //Para recorrerlo
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }

/*3.ListIterator
Para recorrer colecciones / Se usa por los métodos útiles que contiene (Mejora de Iterator / hereda de Iterator)
    -Métodos:
        -.add(objeto) -> Añade el objeto a la coleccion
        -.set(objeto) -> Sustituye el valor de la posicón actual por el valor que le pasamos
        -.previous([indice]) -> Devuelve el anterior a la posicion actual / Si le pasas un indice te devuelve el anterior en base a dicho indice
        -.hasPrevious() -> Devuelve true si hay un objeto antes
        -.nextIndex() -> Devuelve el siguiente indice
 */

    public static void P3(){


        ArrayList<String> coleccion = new ArrayList<>();
        coleccion.add("Gato");
        coleccion.add("Perro");
        coleccion.add("Leon");
        coleccion.add("Tigre");


        ListIterator<String> it = coleccion.listIterator();
        while(it.hasNext()){
            //Primero de to-do posicionarnos en el primero ya que no se posiciona de forma automatica
            it.next();

        }
        //Si queremos recorrelo de forma inversa primero debemos recorrelo normal para posicionarnos al final

        while(it.hasPrevious()){
            //Primero de to-do posicionarnos en el primero ya que no se posiciona de forma automatica
            System.out.println(it.previous());
        }

        while(it.hasNext()){
            //Primero de to-do posicionarnos en el primero ya que no se posiciona de forma automatica
            it.next();
            it.set("Gatito");
        }




        System.out.println(coleccion);











    }

/*3.List
Hereda de ListIterator
    -Métodos:
        -.add(indice,objeto) -> Añade el objeto a la coleccion
        -.remove(indice,objeto) -> Elimina el objeto de la coleccion
        -.get([indice]) -> Devuelve el objeto de la coleccion
        -.set(indice,objeto) -> Sustituye el valor de la posicón actual por el valor que le pasamos
        -.indexOf(objeto) -> Devuelve el indice del objeto en caso de no encontrarlo devuelve -1 (recorre de izquierda a derecha) / solo deuvuelve el primero que encuentra
        -.lastIndexOf(objeto) -> Devuelve el indice del objeto en caso de no encontrarlo devuelve -1 (recorre de derecha a izquierda) / solo deuvuelve el primero que encuentra
        -.addAll(coleccion) -> Añade una coleccion a otra
        -.listIterator() -> Devuelve un listIterator



 */

/*4.LinkedList
    -Métodos:
        -.getFirst() -> Devuelve el primer elemento
        .-getLast() -> Devuelve el ultimo elemento
        .-addFirst(objeto) -> Añade el objeto al principio
        .-addLast(objeto) -> Añade el objeto al final
        .-removeFirst() -> Elimina el primer elemento
        .-removeLast() -> Elimina el ultimo elemento
*/

/*5.Set
Es una interfaz que hereda de colecction pero no de list
Para todos los set debes crear el método equals

    5.1.HashSet:
    Se usa para no tener valores repetidos, si no no es necesaria
    (Ordena por el Hash)
    Si hereda de una clase que tiene un atributo serializable, el hashset tambien lo tendra y por ende no será visualizable por pantalla
    Ej. Tenemos una clase persona, por lo que tendremos que redifinir el metodo equals y el hashcode ->
    (Te lo hace solo IntelIj)

        5.1.1.LinkedHashSet:
        Mantiene el orden de introduccion de los objetos aparte de eliminar los duplicados

    5.2.SortedSet
    Interfaz
    - Métodos:
        - .first()
        - .last()
        - .headSet(Objeto) -> Devuelve un sortedSet con elementos menores al argumento
        - .tailSet(Objeto) -> Lo mismo que el headSet pero mayor o igual
        - .subset(Objeto 1, Objeto 2) -> Combinación de tailset y headset

        5.2.1.TreeSet:
        Estableces tu el orden, para ello ->
        Creas clase
        Creas metodo compareTo, hashCode y equals
        - Métodos:
            - .first()
            - . last()

 */

/* 6. Mapas
    Interfaz Map
    Métodos:
        - .isEmpty()
        - .put(clave, valor) -> Añade el valor a su pareja de clave
        - .get(clave) -> Devuelve el valor de la clave pasada
        - .remove(clave) -> Elimina el registro entero (clave y valor)
        - .containsKey(clave) -> Booleano (si contiene la clave o no)
        - .containsValue(value) -> Booleano (si contiene el valor o no)
        - .putAll(Map) -> Lo mismo que hicimos con el ArrayList pero en un Mapa
        - .size() -> Número de registros/parejas de valores totales
        - .keySet() -> Devuelve una colección con todas las claves. Devuelve un SET
        - .values() -> Devuelve un collection con todos los valores (OJO, NO CLAVES)
        - .clear() -> Se carga to-do el mapa (borrado)

    Clase HashMap (hereda todos los métodos de Map)
*/

/* 7. Ficheros
    Librería: java.io.File
    Siempre que toquemos un fichero, debemos declarar explícitamente que tira una excepción. En concreto, la IOException
    Métodos:
        - File(String ruta) -> Declaramos que el fichero está establecido en una ruta en concreto
        - File(String directorio, String nom_fich O nom_dir) -> Lo mismo pero especificado los tipos que podemos poner
        - .getName() -> Devuelve el nombre del fichero

    Declaración de un fichero: File f = new File("C:\\DOBLE_CONTRABARRA_OBLIGATORIO\\DIR");

    -- FICHEROS NORMALES (.TXT) --

    A TODO ESTO. ACORDARSE DE HACER EL .close() A SU CORRESPONDIENTE. IMPORTANTE !!!!!!!!!

    7.1 FileWriter
    Librería: java.io.FileWriter
    Métodos:
        - .write(char, o char[], o String) -> Escribimos literalmente lo que queramos
        - .append(char) -> Añadimos un carácter al final de nuestra posición. Machaca fichero y escribe

    Declaración de FileWriter: FileWriter fw = new FileWriter(f, [true] -> En el caso de que queramos añadir y/o exista el fichero, NO BORRAR Y EMPEZAR DE CERO);
    Ejemplo: fw.write('c'); fw.close();

    7.2 FileReader
    Librería: java.io.FileReader
    Métodos:
        - .read(int (bytes)) -> Vamos leyendo el fichero y devuelve "-1" si es final de fichero

    7.3 BufferedWriter
    Librería: java.io.BufferedWriter
    Métodos:
        - .newLine() -> Da un Enter

    7.4 BufferedReader
    Librería: java.io.BufferedReader
    Métodos:
        - .readLine() -> Lee la línea entera en vez de caracter a caracter

    -- FICHEROS BINARIOS (.BIN) --

    7.5 FileOutputStream
    Librería: java.io.FileOutputStream
    Inicialización: FileOutputStream fos = new FileOutputStream(f, [false] -> Lo mismo, append);
    Métodos:
        - .write(loqsea) -> Escribe lo que queramos

    7.6 FileInputStream
    Librería: java.io.FileInputStream
    Inicialización: FileInputStream fos = new FileInputStream(f, [false] -> Lo mismo, append);
    Métodos:
        - .read()

    Para leer un fichero:
    int car;
    while ((car = fileInputStream.read()) != -1)
        System.out.println((char)car);

    7.7 DataOutputStream
    Inicialización: DataOutputStream do = new DataOutputStream(new FileOutputStream(f, false/true));
    Métodos:
        - .writeUTF(String)
        - .writeInt(Int)
        - .writeByte(Byte)
        - ...

    7.8 DataInputStream
    Inicialización: DataInputStream do = new DataInputStream(new FileInputStream(f, false/true));
    Métodos:
        - .readUTF(String)
        - .readInt(Int)
        - .readByte(Byte)
        - ...

    7.9 ObjectOutputStream
    Sirve para escribir tus propios objetos
    PASOS:
        - Creamos la clase ObjectOutputStream:
            import java.io.FileOutputStream;
            import java.io.IOException;
            import java.io.ObjectOutputStream;

            public class MiObjectOutputStream extends ObjectOutputStream {

                MiObjectOutputStream(FileOutputStream fO) throws IOException {
                    super(fO);
                }

                protected void writeStreamHeader(){
                }

            }
        - Controlamos el supuesto de los header:
        File f = new File("C:\\Users\\AlumnoM\\Desktop\\" + nomArchivo);
        ObjectOutputStream fo;

        if(f.exists())
            fo = new MiObjectOutputStream(new FileOutputStream(f, true));
        else
            fo = new ObjectOutputStream(new FileOutputStream(f));

        - Establecer que la clase que queremos incluir sea Serializable:
        public class Persona implements Serializable {

            @Serial
            private static final long serialVersionUID = -1577157610399250541L;

        }

    7.10 ObjectInputStream
    Declaración: ObjectInputStream fi = new ObjectInputStream(new FileInputStream(f));
    TODO HACER ESTO DENTRO DE UN TRY CATCH !!!!!!!!!
    Ejemplo:
        ObjectInputStream fi = null;
        try{
            fi = new ObjectInputStream(new FileInputStream(f));

            do{
                System.out.println(fi.readObject());
            }while(true);

        } catch(EOFException e){
            System.out.println("Final de fichero");
        } catch (Exception e){
            System.out.println(e);
        }

        fi.close();

    7.11 Ficheros de acceso aleatorio (RandomAccessFile)
    Clase: RandomAccessFile
    Modos de apertura:
        - read (r)
        - rwrite (rw)

    Métodos:
        - .writeUTF()
        - .writeInt()
        - .writeXnXX()
        - lo mismo con los read
        - .getFilePointer() -> Ver dónde estoy en cada momento

    Declaración: RAF fA = new RAF(f, "rw");
    fw.writeUTF("xnxx");

    Para leerlo, debemos abrir el fichero como lectura y hacer un surround con un try catch y Exception e

    Para rebobinar tenemos el método seek(bytes). Si queremos rebobinar al primer elemento: seek(0)

    CUÁNTO OCUPA CADA CLASE PRIMITIVA:
        - Doubles: 8 bytes
        - Enteros: 4
        - Los char: 2
        - Los boolean: 1
        - Los String: depende. Longitud de cadena x2

    -- INCISO --
    StringBuffer (para establecer una longitud determinada a cada cadena que escribamos):

    StringBuffer sB= new StringBuffer(cadena);
    sB.setLength(15);
    fR.writeChars(sB.toString());

    -- END OF INCISO --

    8. XML
        - Analizador SAX & MiDefaultHeader
            import org.xml.sax.InputSource;
            import org.xml.sax.SAXException;
            import org.xml.sax.XMLReader;
            import org.xml.sax.helpers.DefaultHandler;
            import org.xml.sax.helpers.XMLReaderFactory;

            import java.io.IOException;

            public class AnalizadorSAX {

                @SuppressWarnings("deprecation")
                public static void main(String[] args) throws SAXException, IOException {

                    XMLReader pXML = XMLReaderFactory.createXMLReader();
                    MiDefaultHandler mDF = new MiDefaultHandler();

                    pXML.setContentHandler(mDF);
                    InputSource fichXML = new InputSource("C:\\Users\\AlumnoM\\Desktop\\FichEmpleados.xml");
                    pXML.parse(fichXML);

                }

            }

            class MiDefaultHandler extends DefaultHandler {

                MiDefaultHandler() {
                    super();
                }

                public void startDocument() {
                    System.out.println("Comienzo SAX");
                }

                public void endDocument() {
                    System.out.println("Final SAX");
                }

                public void startElement(String uri, String nombre, String nombreC, org.xml.sax.Attributes atts) {
                    System.out.println("Comienzo elemento: " + nombre);
                }

                public void endElement(String uri, String nombre, String nombreC) {
                    System.out.println("Fin elemento: " + nombre);
                }

                // getLength -> Número de atributos | Ejemplo: <apellidos orden="primero" orden3="tercero"> -> getLength = 2
                // getLocalName(0) -> Devuelve el nombre del atributo | Ejemplo: <apellidos orden="primero" orden3="tercero"> -> getLocalName(0) = orden
                // getValue(0) -> Devuelve el valor del atributo | Ejemplo: <apellidos orden="primero" orden3="tercero"> -> getValue(0) = primero

                public void characters(char[] ch, int inicio, int longitud) {
                    String car = new String(ch, inicio, longitud);
                    System.out.println(car);
                }
            }

        - Consultas XPATH
            import org.w3c.dom.Document;
            import org.w3c.dom.NodeList;
            import org.xml.sax.SAXException;

            import javax.xml.parsers.DocumentBuilder;
            import javax.xml.parsers.DocumentBuilderFactory;
            import javax.xml.parsers.ParserConfigurationException;
            import javax.xml.xpath.*;
            import java.io.File;
            import java.io.IOException;

            public class JugandoConXPath {

                public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {

                    File f = new File("C:\\Users\\AlumnoM\\Desktop\\FichEmpleados.xml");
                    DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dB = dBF.newDocumentBuilder();
                    Document docL = dB.parse(f);

                    XPathFactory xPF = XPathFactory.newInstance();
                    XPath xP = xPF.newXPath();

                    XPathExpression xExp = xP.compile("count(//Empleados/Empleado)");
                    Object objNumEmp = xExp.evaluate(docL);
                    System.out.println("Número de empleados: " + objNumEmp);

                    System.out.println("El apellido1 del atributo con valor 'primero'");
                    xExp = xP.compile("//Empleados/Empleado/apellidos[@orden='primero']/apellido1");
                    NodeList nl = (NodeList) xExp.evaluate(docL, XPathConstants.NODESET);

                    for (int i = 0; i < nl.getLength(); i++)
                        System.out.println(nl.item(i).getTextContent());

                }

            }
        - Programa Principal:
            import org.w3c.dom.*;
            import org.xml.sax.SAXException;

            import javax.xml.parsers.DocumentBuilder;
            import javax.xml.parsers.DocumentBuilderFactory;
            import javax.xml.parsers.ParserConfigurationException;
            import javax.xml.transform.*;
            import javax.xml.transform.dom.DOMSource;
            import javax.xml.transform.stream.StreamResult;
            import java.io.File;
            import java.io.IOException;

            public class Main {
                public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException, SAXException {
                    File f = new File("C:\\Users\\AlumnoM\\Desktop\\FichEmpleados.xml");

                    org.w3c.dom.Element raiz;
                    org.w3c.dom.Element elem;
                    org.w3c.dom.Element elemSub;
                    Text text;
                    Attr attr;

                    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                    DocumentBuilder db = dbf.newDocumentBuilder();

                    DOMImplementation imp = db.getDOMImplementation();

                    // Creamos la etiqueta raíz del XML (en este caso, "Empleados")
                    Document doc = imp.createDocument(null, "Empleados", null);
                    doc.setXmlVersion("1.0");

                    // Creamos la etiqueta "Empleado" y la añadimos a la raíz
                    raiz = doc.createElement("Empleado");
                    doc.getDocumentElement().appendChild(raiz);

                    // Creamos la etiqueta "id" con valor "1" y la añadimos a la etiqueta "Empleado"
                    elem = doc.createElement("id");
                    text = doc.createTextNode("1");
                    raiz.appendChild(elem);
                    elem.appendChild(text);

                    // Creamos la etiqueta "apellidos" y lo añadimos a la etiqueta "Empleado"
                    elem = doc.createElement("apellidos");
                    raiz.appendChild(elem);
                    attr = doc.createAttribute("orden");
                    attr.setValue("primero");
                    elem.setAttributeNode(attr);

                    // Creamos la etiqueta "apellido1" con valor "Pérez" y la añadimos a la etiqueta "apellidos"
                    elemSub = doc.createElement("apellido1");
                    text = doc.createTextNode("Pérez");
                    elem.appendChild(elemSub);
                    elemSub.appendChild(text);

                    // Creamos la etiqueta "apellido2" con valor "Sánz" y la añadimos a la etiqueta "apellidos"
                    elemSub = doc.createElement("apellido2");
                    text = doc.createTextNode("Sánz");
                    elem.appendChild(elemSub);
                    elemSub.appendChild(text);

                    // Creamos la etiqueta "dep" con valor "150" y la añadimos a la etiqueta "Empleado"
                    elem = doc.createElement("dep");
                    text = doc.createTextNode("150");
                    raiz.appendChild(elem);
                    elem.appendChild(text);

                    // EMPLEADO NÚMERO 2

                    // Creamos la etiqueta "Empleado" y la añadimos a la raíz
                    raiz = doc.createElement("Empleado");
                    doc.getDocumentElement().appendChild(raiz);

                    // Creamos la etiqueta "id" con valor "1" y la añadimos a la etiqueta "Empleado"
                    elem = doc.createElement("id");
                    text = doc.createTextNode("2");
                    raiz.appendChild(elem);
                    elem.appendChild(text);

                    // Creamos la etiqueta "apellidos" y lo añadimos a la etiqueta "Empleado"
                    elem = doc.createElement("apellidos");
                    raiz.appendChild(elem);
                    attr = doc.createAttribute("orden");
                    attr.setValue("primero");
                    elem.setAttributeNode(attr);

                    // Creamos la etiqueta "apellido1" con valor "Pérez" y la añadimos a la etiqueta "apellidos"
                    elemSub = doc.createElement("apellido1");
                    text = doc.createTextNode("González");
                    elem.appendChild(elemSub);
                    elemSub.appendChild(text);

                    // Creamos la etiqueta "apellido2" con valor "Sánz" y la añadimos a la etiqueta "apellidos"
                    elemSub = doc.createElement("apellido2");
                    text = doc.createTextNode("Ruíz");
                    elem.appendChild(elemSub);
                    elemSub.appendChild(text);

                    // Creamos la etiqueta "dep" con valor "150" y la añadimos a la etiqueta "Empleado"
                    elem = doc.createElement("dep");
                    text = doc.createTextNode("150");
                    raiz.appendChild(elem);
                    elem.appendChild(text);

                    // FIN EMPLEADO NÚMERO 2

                    Source source = new DOMSource(doc);
                    Result result = new StreamResult(f);
                    Transformer transf = TransformerFactory.newInstance().newTransformer();
                    transf.transform(source, result);

                    System.out.println("Fichero XML creado correctamente");

                    leerFicheroXML(f);

                }

                public static void leerFicheroXML(File f) throws ParserConfigurationException, IOException, SAXException {
                    Element element = null;

                    DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dB = dBF.newDocumentBuilder();

                    Document docL = dB.parse(f);
                    NodeList empleados = docL.getElementsByTagName("Empleado");
                    System.out.println(empleados.getLength());

                    for(int i = 0; i < empleados.getLength(); i++) {
                        Node emp = empleados.item(i);
                        element = (Element) emp;

                        System.out.println(element.getElementsByTagName("id").item(i).getTextContent());
                        System.out.println(element.getElementsByTagName("apellido1").item(i).getTextContent());
                        Element elemAt = (Element) element.getElementsByTagName("apellidos").item(0);
                        System.out.println(elemAt.getAttribute("orden"));
                    }

                }
            }

FIN DE FICHERO

*/
}









