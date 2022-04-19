import './RegisterPage.css';
import Grid from '@material-ui/core/Grid';
import left_img from '../images/left_img.png';
import insta_logo from '../images/logoinsta.png';
import fb from '../images/fb.png';
import appstore from '../images/app.png';
import playstore from '../images/play.png';
//mport SignIN from '../signIn/SignIN';
//import SignUp from '../signUp/SignUp';

function RegisterPage (){

        return (
            <div className="login-page">
                <div className="container">
                    <div className="left-img"><img className="leftside-img" src={left_img}/></div>
                    <div className="right-box">
                        <h1>Fakestagram</h1>
                        <div className="signIn-section">
                            <input className="input" type="text" placeholder="Email, Username"/>
                            <input className="input"type="password"placeholder="Password"/>
                        </div>
                        <button className="signIn-button">Register</button>
                        <div className="login-or-section">
                            <hr className="divide"></hr>
                            <div>OR</div>
                            <hr className="divide"></hr>
                        </div>

                        <div className="login-fb"><img src={fb} width="15px" style={{"marginRight":"5px "}}/>Log in with Facebook</div>
                        <div className="forgot-password">Forgot password?</div>

                        <div className="signup-cont">
                            <div className="no-account">Already have an account? <span style={{"fontWeight":"bold", "color": "#0395F6"}}>Sign in</span></div>
                        </div>

                        <div className="download-section">
                            <div>
                                Get the app.
                            </div>
                            <div className="loginPage-option">
                                <img className="loginPage_dwimg" src={appstore} width="136px" />
                                <img className="loginPage_dwimg" src={playstore} width="136px" />
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        );

}

export default RegisterPage;