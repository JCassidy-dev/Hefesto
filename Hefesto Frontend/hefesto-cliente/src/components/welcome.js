export default function Welcome(props) {
    console.log(props);
    const { message } = props;
    return (
        <div>
            <h1>Bem-vindo ao Hefesto!</h1>
            <p>Estamos felizes em tê-lo conosco. Explore nossos recursos e aproveite a experiência!</p>
            <p>{message}</p>
        </div>

    );
}