import { Cargo } from "./cargo.model";

export class Funcionario {
    id: number | undefined;
    nome: string | undefined;
    dataNascimento: Date | undefined;
    cargo: Cargo | undefined;
}