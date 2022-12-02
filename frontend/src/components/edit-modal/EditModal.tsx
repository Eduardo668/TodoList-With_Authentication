import { Container, Modal } from "./style"

type Props = {
    closeEditModal:()=>void,
    editTask:()=>void,
    title:string,
    handleNewTitle:(new_title:string)=>void
}

export const EditModal = ({ closeEditModal, editTask, title, handleNewTitle }:Props)=>{
    return(
        <>
            <Container>
                <Modal>
                    <div className="text-div">
                        <h3>Type the new task title</h3>
                    </div>
                    <div className="input-div">
                        <input placeholder={title} onChange={(e)=>handleNewTitle(e.target.value)} type="text" />
                    </div>
                    <div className="input-div">
                        <button onClick={()=>editTask()} >Edit</button>
                        <button onClick={closeEditModal} >Cancel</button>
                    </div>
                </Modal>
            </Container>
        </>

    )
}