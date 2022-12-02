import { Container, Modal } from "./style"

type Props ={
    closeDeleteModal:()=>void,
    deleteTask:()=>void
}

export const DeleteModal = ({closeDeleteModal, deleteTask}:Props)=>{
    return(
        <>
            <Container>
                <Modal>
                    <div className="text-div">
                        <h3>Do you really want to delete this task?</h3>
                    </div>
                    <div className="btn-div" >
                        <button onClick={()=>deleteTask()} className="yes-btn">Yes</button>
                        <button onClick={closeDeleteModal} className="yes-btn">No</button>
                    </div>
                </Modal>
            </Container>

        </>
    )
}