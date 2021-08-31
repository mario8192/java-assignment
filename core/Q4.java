
class MessageResource {
	private String message = "";

	public MessageResource() {
		if (message=="") {
			this.message = "Intial Synchronised Message";
		}
	}

	public synchronized String readResource() {
		return message;
	}

	public synchronized String writeResource(String newMessage) throws Exception {
		if (newMessage=="") {
			throw new Exception("Message cannot be empty");
		}
		this.message = newMessage;
		return this.message;
	}
}

class ReaderThread extends Thread{
    private MessageResource resource;

    ReaderThread(MessageResource resource){
        this.resource=resource;
    }

    @Override
    public void run(){
        for(int i=0;i<=5;i++){
            System.out.println(resource.readResource());
        }
    }
}

class WriterThread extends Thread{
    private MessageResource resource;
    private String message;

    WriterThread(MessageResource resource,String message){
        this.resource=resource;
        this.message=message;
    }

    @Override
    public void run(){
        try{
            for(int i=0;i<=5;i++){
                String dataWritten= this.resource.writeResource(this.message);
                System.out.println("Following message was written to resource = "+ dataWritten);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}


class main{
    public static void main(String[] args) throws Exception {
        MessageResource messageObject=new MessageResource();

        Thread ReaderThread= new ReaderThread(messageObject);
        Thread WriterThread= new WriterThread(messageObject,"Loading the sample data!!");

        //starting both of the threads.
        ReaderThread.start();
        WriterThread.start();

    }
}